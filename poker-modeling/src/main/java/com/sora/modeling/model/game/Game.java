package com.sora.modeling.model.game;

import com.google.common.collect.Lists;
import com.sora.modeling.enums.Action;
import com.sora.modeling.enums.Street;
import com.sora.modeling.enums.Suit;
import com.sora.modeling.model.card.Card;
import com.sora.modeling.model.card.Hand;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import static com.sora.modeling.enums.Street.*;

/**
 * Created by yujingyi on 2019/4/10.
 */
@Data
public class Game {

    private int sbPrice;

    private int bbPrice;

    private Street currentStreet;

    private Map<Integer, Hand> playerHands = new HashMap<>();

    private Map<Street, LinkedList<PlayerAction>> actions = new HashMap<>();

    public Game(int playerNum) {
        initStreet();
        initPlayHands(playerNum);
    }

    private void initStreet() {
        actions.put(PRE_FLOP, Lists.newLinkedList());
        actions.put(FLOP, Lists.newLinkedList());
        actions.put(TURN, Lists.newLinkedList());
        actions.put(RIVER, Lists.newLinkedList());
        currentStreet = PRE_FLOP;
    }

    private void initPlayHands(int playerNum) {
        for (int i = 0; i < playerNum; ++i) {
            Hand hand = new Hand();
            hand.setPosition(i);
            addPlayHand(i, hand);
        }
    }

    private void initBlindInPreFlop() {
        addAction(0, Action.BET, 1);
        addAction(1, Action.BET, 2);
    }

    public void start() {
        initBlindInPreFlop();
    }

    public void updatePlayHand(int position, Card[] cards, Integer original, Integer current) {
        Hand hand = playerHands.get(position);
        if (cards != null && cards.length > 0) {
            hand.setCards(cards);
        }
        if (original != null) {
            hand.setOriginalBBs(original);
        }
        if (current != null) {
            hand.setCurrentBBs(current);
        }

    }

    public void descPlayHandBBs(int position, int num) {
        Hand hand = playerHands.get(position);
        hand.descBBs(num);
    }

    public void addPlayHand(int position, Hand hand) {
        playerHands.put(position, hand);
    }

    public void addAction(int position, Action action, int num) {
        PlayerAction newAction = new PlayerAction(position, action, num);
        LinkedList<PlayerAction> curStreetActionList = actions.get(currentStreet);
        curStreetActionList.add(newAction);
        descPlayHandBBs(position, num);
    }

    public String printGame() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player Hands:\n");
        for (Entry<Integer, Hand> entry : playerHands.entrySet()) {
            builder.append("Postion: " + entry.getKey())
                    .append(" hands: " + entry.getValue().cardsToString())
                    .append(" left: " + entry.getValue().getCurrentBBs())
                    .append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Game game = new Game(7);
        Card[] bbCards = {Card.builder().point(1).suit(Suit.CLUB).build(), Card.builder().point(1).suit(Suit.HEART).build()};
        Card[] sbCards = {Card.builder().point(13).suit(Suit.CLUB).build(), Card.builder().point(13).suit(Suit.HEART).build()};
        game.updatePlayHand(0, bbCards, 200, 200);
        game.updatePlayHand(1, sbCards, 200, 200);
        game.start();
        System.out.println(game.printGame());
    }
}
