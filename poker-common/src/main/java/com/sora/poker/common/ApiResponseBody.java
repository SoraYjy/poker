package com.sora.poker.common;

import com.sora.poker.common.utils.JSONUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yujingyi on 2017/5/6.
 */
@Data
@NoArgsConstructor
public class ApiResponseBody<T> {

    @ApiModelProperty(value = "状态码")
    private String code;

    @ApiModelProperty(value = "状态信息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;

    protected ApiResponseBody(String code, String msg, T data){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ApiResponseBody create(String code, String error, T data){
        return new ApiResponseBody(code, error, data);
    }

    public static ApiResponseBody createErrorBody(String code, String error){
        return new ApiResponseBody(code, error, null);
    }

    public static <T> ApiResponseBody createSuccessBody(T data){
        return new ApiResponseBody(ApiResponseCode.SUCCESS.getCode(), ApiResponseCode.SUCCESS.getMsg(), data);
    }

    @Override
    public String toString() {
        return JSONUtil.jsonEncode(this);
    }
}
