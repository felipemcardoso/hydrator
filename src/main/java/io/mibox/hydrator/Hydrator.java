package io.mibox.hydrator;

import java.lang.reflect.Field;

/**
 * Created by felipe on 11/08/17.
 * felipe.computacao@gmail.com
 * Description:
 */
public class Hydrator {

    private final Object object;

    private Hydrator(Object object) {
        this.object = object;
    }

    public static Hydrator newInstance(Object object) {
        return new Hydrator(object);
    }

    public void setInt(int value, String fieldName) throws NoSuchFieldException {

        Field f = getField(fieldName);

        setValue(f, value);
    }

    private void setValue(Field field, Object value) {
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Field getField(String fieldName) {

        try {
            Field f = object.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);

            return f;

        } catch (java.lang.NoSuchFieldException e) {
            throw new NoSuchFieldException(fieldName);
        }
    }
}
