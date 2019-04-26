package com.sora.poker.common.utils;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;

/**
 * Created by yujingyi on 2017/5/22.
 */
@Log4j2
public class UUIDUtils {
    public static String getUUID() {
        /*UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13)
                + str.substring(14, 18) + str.substring(19, 23)
                + str.substring(24);
        return temp;*/

        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getUUID());
    }
}
