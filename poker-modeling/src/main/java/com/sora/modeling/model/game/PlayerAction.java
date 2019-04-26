package com.sora.modeling.model.game;

import com.sora.modeling.enums.Action;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yujingyi on 2019/4/18.
 */
@Data
@AllArgsConstructor
public class PlayerAction {

    private int position;

    private Action action;

    private int put;

}
