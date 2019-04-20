package com.donnie.grow.utils;

public class RandomUtils {


    /**
     * 返回当前 毫秒数+三位随机数
     */
    public static String generateRandomNumStr() {
        //当前毫秒数
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        //随机三位数
        String randomNumStrForLength3 = String.valueOf((int)(Math.random()*1000));
        return currentTimeMillis + randomNumStrForLength3;
    }
}
