package com.sora.poker.common;

import lombok.Builder;
import lombok.Data;

/**
 * Created by yujingyi on 2017/5/6.
 */
@Data
@Builder
public class CommonServiceException extends RuntimeException {

    private String code;
    private String message;

    public CommonServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
