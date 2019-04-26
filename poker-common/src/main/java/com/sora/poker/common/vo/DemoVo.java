package com.sora.poker.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by yujingyi on 2017/12/15.
 */
@Data
@Builder
public class DemoVo {

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "id")
    private int id;

}
