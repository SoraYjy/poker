package com.sora.modeling.model.card;

import com.sora.modeling.enums.Suit;

import java.util.Random;

/**
 * Created by yujingyi on 2018/8/28.
 */
public class Deck {
    final static int[] points = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1};
    final static Suit[] suits = {Suit.SPADE, Suit.HEART, Suit.CLUB, Suit.DIAMOND};

    private Card[] cards;
    private int cursor = 0;

    public Deck() {
        buildDeck();
    }

    private void buildDeck() {
        cards = new Card[52];
        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < suits.length; ++j) {
                cards[i * suits.length + j] = Card.builder()
                        .point(points[i])
                        .suit(suits[j])
                        .build();
            }
        }
    }

    /**
     * Durstenfeld shuffle
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; --i) {
            int j = random.nextInt(i);
            Card tmp = cards[j];
            cards[j] = cards[i];
            cards[i] = tmp;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cards.length; ++i) {
            builder.append(cards[i].getPoint())
                    .append(" ")
                    .append(cards[i].getSuit().getShortName())
                    .append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.toString());
        deck.shuffle();
        System.out.println(deck.toString());
    }
}
