package com.donnie.grow.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {

    public static String encode(String input) throws UnsupportedEncodingException {
        final Base64.Encoder encoder = Base64.getEncoder();
        final byte[] inputBytes = input.getBytes("UTF-8");
        return encoder.encodeToString(inputBytes);
    }

    public static String decode(String input) throws UnsupportedEncodingException {
        final Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(input), "UTF-8");
    }
}
