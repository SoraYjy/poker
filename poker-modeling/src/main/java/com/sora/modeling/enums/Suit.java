package com.sora.modeling.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yujingyi on 2018/8/28.
 */
@Getter
@AllArgsConstructor
public enum Suit {
    SPADE("s"),
    HEART("h"),
    CLUB("c"),
    DIAMOND("d"),
    UNKNOWN("unknown");

    private String shortName;


}
