package com.sora.poker.api;

import com.sora.poker.common.ApiResponseBody;
import com.sora.poker.common.ApiResponseCode;
import com.sora.poker.common.CommonServiceException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by yujingyi on 2017/5/6.
 */
@Log4j2
public abstract class BaseController {
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApiResponseBody handleException(HttpServletRequest request,
                                           Exception ex,
                                           HttpServletResponse response){

        String uri = "";
        if(StringUtils.isNotEmpty(request.getRequestURI())){
            uri = request.getRequestURI();
        }
        if(ex instanceof IOException){
            log.error(getLogError(ex.getMessage(), request));
            log.info("IOException 客户端读取数据超时 已关闭连接 url: {} ", uri);
        }else{
            log.error(getLogError(ex.getMessage(), request));
            log.error("未处理异常: "+ uri, ex);
        }

        return ApiResponseBody.create(ApiResponseCode.SYSTEM_ERROR.getCode(), "请求出错!", null);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApiResponseBody handleParameterException(HttpServletRequest request,
                                                    MissingServletRequestParameterException ex,
                                                    HttpServletResponse response){

        log.error(getLogError(ex.getMessage(), request));
        log.error("wrong code: " + ApiResponseCode.PARAM_ILLEGAL.getCode() + ", msg: " + ex.getMessage());
        return ApiResponseBody.create(ApiResponseCode.PARAM_ILLEGAL.getCode(), ex.getMessage(), null);
    }

    @ExceptionHandler(CommonServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ApiResponseBody handleServiceException(HttpServletRequest request,
                                                  CommonServiceException ex,
                                                  HttpServletResponse response){

        log.error(getLogError(ex.getMessage(), request));
        return ApiResponseBody.create(ex.getCode(), ex.getMessage(), null);
    }

    /**
     * 获取登陆用户信息
     * @param request
     * @return
     */
//    public UserInfo getUserInfo(HttpServletRequest request){
//        UserInfo userInfo = (UserInfo) request.getAttribute(CommonUtils.CURRENT_USER_INFO);
//        if(userInfo != null){
//            return userInfo;
//        }
//        return null;
//    }

    /**
     * 校验参数
     * @param result
     * @return
     */
    protected ApiResponseBody validParams(BindingResult result) {
        List<FieldError> errors = result.getFieldErrors();
        for (FieldError error : errors) {
            String fieldName = error.getField();
            String msg = error.getDefaultMessage();
            return ApiResponseBody.createErrorBody(ApiResponseCode.PARAM_ILLEGAL.getCode(), msg);
        }

        return null;
    }

    public String getLogInfo(Long start, HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("api:").append(request.getRequestURI()).append(", ");
        builder.append("costs:").append(System.currentTimeMillis() - start).append(", ");
        return builder.toString();
    }

    public String getLogError(String msg, HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("api:").append(request.getRequestURI()).append(", ");
        builder.append("msg:").append(msg).append(", ");
        return builder.toString();
    }

}
