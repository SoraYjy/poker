package com.sora.modeling.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yujingyi on 2019/4/18.
 */
@Getter
@AllArgsConstructor
public enum Street {
    PRE_FLOP("preFlop"),
    FLOP("flop"),
    TURN("turn"),
    RIVER("river");

    private String shortName;

}
