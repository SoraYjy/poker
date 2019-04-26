package com.sora.modeling.model.card;

import com.sora.modeling.enums.Suit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yujingyi on 2018/8/28.
 */
@Data
@AllArgsConstructor
@Builder
public class Card {
    private Suit suit;
    private int point;
}
