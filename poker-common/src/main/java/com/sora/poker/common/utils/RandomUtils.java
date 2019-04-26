package com.sora.poker.common.utils;

import java.util.Random;

/**
 * Created by yujingyi on 2017/11/8.
 */
public class RandomUtils {

    static final private String RANDOM_STRING_BASE = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomStr(int length, boolean upperCase) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(RANDOM_STRING_BASE.length());
            sb.append(RANDOM_STRING_BASE.charAt(number));
        }
        if (upperCase) {
            return sb.toString().toUpperCase();
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(generateRandomStr(32, true));
        System.out.println(generateRandomStr(32, false));
    }
}
