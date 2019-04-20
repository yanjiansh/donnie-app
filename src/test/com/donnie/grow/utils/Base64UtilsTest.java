package com.donnie.grow.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Base64UtilsTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        String input = "ABCD";
        String encodeResult = Base64Utils.encode(input);
        System.out.println("encodeResult:" + encodeResult);
        String decodeResult = Base64Utils.decode(encodeResult);
        System.out.println("decodeResult:" + decodeResult);
        Assert.assertEquals(input, decodeResult);
    }
}
