package com.sora.modeling.model.card;

import lombok.Data;

/**
 * Created by yujingyi on 2018/8/29.
 * User Game
 */
@Data
public class Hand {
    private Card[] cards = {Card.unknowCard(), Card.unknowCard()};

    /**
     * from 0, sb, bb, utg... until btn
     */
    private int position = -1;

    /**
     * BBs before this game
     */
    private int originalBBs = 0;

    /**
     * BBs now
     */
    private int currentBBs = 0;

    public void descBBs(int bbs) {
        currentBBs -= bbs;
    }

    public String cardsToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cards.length; ++i) {
            builder.append(cards[i].toString())
                    .append(" ");

        }
        return builder.substring(0, builder.length() - 1);
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//    }
}
