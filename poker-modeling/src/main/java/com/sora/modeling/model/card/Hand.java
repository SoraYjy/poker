package com.sora.modeling.model.card;

import lombok.Data;

/**
 * Created by yujingyi on 2018/8/29.
 * User Game
 */
@Data
public class Hand {
    private Card[] hand;

    /**
     * from 0, sb, bb, utg... until btn
     */
    private int position;
}
