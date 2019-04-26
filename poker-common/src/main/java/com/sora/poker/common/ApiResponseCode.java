package com.sora.poker.common;

import lombok.Getter;

/**
 * Created by yujingyi on 2017/5/6.
 */
@Getter
public enum ApiResponseCode {

    SUCCESS("A00001", "success"),
    PARAM_ILLEGAL("A00002", "参数非法!"),
    UPDATE_FAILED("A00003", "数据写入失败!"),
    DATA_NOT_EXIST("A00004", "数据不存在!"),
    DATA_INCORRECT("A00005", "数据不正确!"),
    MAX_INCORRECT("A00009", "已达到人数上限，无法加入"),
    INVITE_FAILED("A00007","无法邀请带活动费用或者违约金活动"),
    PERMISSION_DENIED("A00006", "您没有权限!"),
    DATA_EXISTED("A00008", "数据已存在!"),
    NO_ENOUGH_MONEY("A000010", "账户余额不足"),
    USER_HAS_JOINED("A00011", "用户已经加入!"),
    CAN_NOT_SIGNED("A00012", "不能进行签到!"),
    TIME_INVALID("A00013", "时间无效!"),
    NOT_AUTHORIZED("L00000", "token无效"),
    PASSWORD_WRONG("L00001", "密码错误"),
    USER_NOT_EXIST("L00002", "用户不存在"),
    USER_LOCKED("L00003", "用户被琐定"),
    CAPTCHA_WRONG("L00004", "验证码错误"),
    HX_AUTH_FAILED("H00001", "环信access token获取失败"),
    HX_REQUEST_FAILED("H00002", "环信接口调用失败"),
    NO_AUTH("A00101", "您没有权限!"),
    USER_TYPE_WRONG("A00102", "您没有老师的权限!"),
    AGENT_TYPE_NOT_SUPPORT("A00200", "不支持手机端播放!"),
    PAY_SIGN_GENERATE_FAILED("P00001", "生成支付签名失败!"),
    USER_PAY_INFO_MISSED("P00002", "用户支付信息不存在!"),
    APP_PAY_FAILED("P00003", "APP支付失败!"),
    ORDER_WRONG("P00004", "订单不存在或已结算!"),
    GET_PRE_PAY_INFO_FAILED("P00004", "获取预支付信息失败!"),
    WECHAT_AUTH_FAILED("W00001", "微信授权失败!"),
    WECHAT_USER_INFO_FETCH_FAILED("W00002", "微信用户信息获取失败!"),
    NOT_ENOUGH_BALANCE("W00003", "余额不足!"),
    PAY_BUSINESS_TYPE_WRONG("W00004", "支付渠道不存在!"),
    WITHDRAW_REQUEST_FAILED("W00005", "转帐请求失败!"),
    SYSTEM_ERROR("E00001", "系统错误!");
//    NOT_AUTHORIZED(-20001, "authcookie is invalid"),
//    JSON_PARSE_ERROR(-20002, "json parsing is unusual, please check the format"),
//    PARAM_NULL(-20003, "request body is empty"),
//    RESPONSE_BODY_NULL(-20004, "response is empty"),
//    PARAM_ILLEGAL(-20005, "param is illegal"),
//    SYSTEM_ERROR(-10000, "system error");

    private String code;
    private String msg;

    ApiResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
