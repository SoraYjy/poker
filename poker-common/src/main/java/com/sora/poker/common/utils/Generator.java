package com.sora.poker.common.utils;

import java.util.Random;

/**
 * Created by yujingyi on 2017/5/25.
 */
public class Generator {
    private final static String orderNoPrefix = "DD";

    public static String generateAuthCookie(String account, String password) {
        StringBuilder builder = new StringBuilder()
                .append(account)
                .append(password)
                .append(System.currentTimeMillis());

        return EncodeUtils.MD5(builder.toString(), "utf-8").toUpperCase();
    }

    public static String generateToken(String id, String account, String passwordMD5, String sId) {
        return EncodeUtils.MD5(
                (id + account + passwordMD5 + sId + System.currentTimeMillis()), "utf-8");

    }

    public static String generateAuthenticationCode() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 6; ++i) {
            builder.append((int) (Math.random() * 10));
        }

        return builder.toString();
    }

    public static String generateNineDigitNumber() {
        Random random = new Random();
        return ((random.nextInt(9) % 9 + 1)) + "" + random.nextInt(100000000);

    }

    public static String generateRandomString() {
        return EncodeUtils.MD5(System.currentTimeMillis() + "", "utf-8");
    }

    public static void main(String[] args) {

//        System.out.println(generateAuthCookie("yjy", "bc"));

        for(int i = 0; i < 100; ++i) {
            System.out.println(generateNineDigitNumber());
        }

    }
}
