package com.fast.logintest.exception;

/**
 * 学习标记：这是业务异常类。
 * 企业项目里，像“用户名已存在”“用户不存在”“密码错误”这类可预期业务问题，
 * 不建议到处手写 AjaxResult.error(...)，而是统一抛业务异常，再交给全局异常处理器兜底。
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
