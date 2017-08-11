package io.mibox.hydrator;

import org.junit.Assert;

/**
 * Created by felipe on 11/08/17.
 * felipe.computacao@gmail.com
 * Description:
 */
public class HydratorTest {

    @org.junit.Test
    public void setInt() throws Exception {

        CompositeModel model = new CompositeModel(1);

        Hydrator hydrator = Hydrator.newInstance(model);

        hydrator.setInt(10, "field1");

        Assert.assertEquals(10, model.getField1());
    }

}