package com.nopecommerce.admin.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C {
    int i=1;
    @Test
    public void functionC(){

        if(i==3)
        Assert.assertTrue(true);
        else
        {
            i++;
            Assert.assertTrue(false);

        }
    }
}
