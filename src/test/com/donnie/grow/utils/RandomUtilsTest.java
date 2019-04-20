package com.donnie.grow.utils;

import org.junit.Assert;
import org.junit.Test;

public class RandomUtilsTest {

    @Test
    public void generateRandomNumStrTest() {
        String r1 = RandomUtils.generateRandomNumStr();
        String r2 = RandomUtils.generateRandomNumStr();
        Assert.assertFalse(r1.equals(r2));
    }

}
