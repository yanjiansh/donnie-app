package com.donnie.grow.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public class RSAUtilsTest {

    @Test
    public void test() throws UnsupportedEncodingException, InvalidKeySpecException, NoSuchAlgorithmException {
        Map<String, String> keyMap = RSAUtils.createKeys(2048);
        String publicKey = keyMap.get("publicKey");
        String privateKey = keyMap.get("privateKey");
        System.out.println("publicKey:" + publicKey);
        Assert.assertNotNull(publicKey);
        System.out.println("privateKey:" + privateKey);
        Assert.assertNotNull(privateKey);

        RSAPublicKey rsaPublicKey = RSAUtils.getPublicKey(publicKey);
        RSAPrivateKey rsaPrivateKey = RSAUtils.getPrivateKey(privateKey);

        String input = "ABCD";
        System.out.println("input:" + input);
        String encryptResult = RSAUtils.publicEncrypt(input, rsaPublicKey);
        System.out.println("encryptResult:" + encryptResult);
        String decryptResult = RSAUtils.privateDecrypt(encryptResult, rsaPrivateKey);
        System.out.println("decryptResult:" + decryptResult);

    }


}
