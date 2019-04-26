package com.sora.modeling.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yujingyi on 2019/4/10.
 */
@Getter
@AllArgsConstructor
public enum Action {
    CHECK("x"),
    BET("b"),
    FOLD("f"),
    RAISE("r"),
    CALL("c"),
    ALLIN("a");

    private String shortName;

}
