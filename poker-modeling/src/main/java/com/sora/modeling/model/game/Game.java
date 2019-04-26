package com.sora.modeling.model.game;

import com.sora.modeling.enums.Action;
import com.sora.modeling.model.card.Hand;
import lombok.Data;

import java.util.LinkedList;

/**
 * Created by yujingyi on 2019/4/10.
 */
@Data
public class Game {

    private int sbPrice;

    private int bbPrice;

    private LinkedList<PlayerAction> preFlop;

    private LinkedList<PlayerAction> flop;

    private LinkedList<PlayerAction> turn;

    private LinkedList<PlayerAction> river;

    private void initBlindInPreFlop() {
//        PlayerAction sbAction = new PlayerAction(0, Action.BET, sb, )
    }


    public static class PlayerHands {
        private Hand sb;

        private Hand bb;

        private Hand utg;

        private Hand utgPlus1;

        private Hand utgPlus2;

        private Hand mp;

        private Hand mpPlus1;

        private Hand mpPlus2;

        private Hand hj;

        private Hand co;

        private Hand btn;
    }
}
