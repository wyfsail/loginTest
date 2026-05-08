package com.fast.logintest.domain;


import java.util.HashMap;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 13:18
 * @Version: 1.0
 */
public class AjaxResult extends HashMap<String, Object> {

    /** 响应成功状态码 */
    public static final int SUCCESS = 200;
    /** 响应失败状态码 */
    public static final int FAIL = 500;

    /**
     * 无参构造
     */
    public AjaxResult() {
    }

    /**
     * 构造方法：状态码 + 消息
     * @param code 状态码
     * @param msg 响应消息
     */
    public AjaxResult(int code, String msg) {
        super.put("code", code);
        super.put("msg", msg);
    }

    /**
     * 构造方法：状态码 + 消息 + 数据
     * @param code 状态码
     * @param msg 响应消息
     * @param data 响应数据
     */
    public AjaxResult(int code, String msg, Object data) {
        super.put("code", code);
        super.put("msg", msg);
        if (data != null) {
            super.put("data", data);
        }
    }

    /**
     * 链式添加自定义字段
     * @param key 字段名
     * @param value 字段值
     * @return 当前对象，支持链式调用
     */
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    //==================== 成功响应方法 ====================
    /**
     * 成功响应（无消息、无数据，默认消息：操作成功）
     * @return AjaxResult
     */
    public static AjaxResult success() {
        return new AjaxResult(SUCCESS, "操作成功");
    }

    /**
     * 成功响应（自定义消息，无数据）
     * @param msg 响应消息
     * @return AjaxResult
     */
    public static AjaxResult success(String msg) {
        return new AjaxResult(SUCCESS, msg);
    }

    /**
     * 成功响应（默认消息：操作成功，带数据）
     * @param data 响应数据
     * @return AjaxResult
     */
    public static AjaxResult success(Object data) {
        return new AjaxResult(SUCCESS, "操作成功", data);
    }

    /**
     * 成功响应（自定义消息 + 数据）
     * @param msg 响应消息
     * @param data 响应数据
     * @return AjaxResult
     */
    public static AjaxResult success(String msg, Object data) {
        return new AjaxResult(SUCCESS, msg, data);
    }

    //==================== 失败响应方法 ====================
    /**
     * 失败响应（默认消息：操作失败）
     * @return AjaxResult
     */
    public static AjaxResult error() {
        return new AjaxResult(FAIL, "操作失败");
    }

    /**
     * 失败响应（自定义消息）
     * @param msg 响应消息
     * @return AjaxResult
     */
    public static AjaxResult error(String msg) {
        return new AjaxResult(FAIL, msg);
    }

    /**
     * 失败响应（自定义状态码 + 消息）
     * @param code 状态码
     * @param msg 响应消息
     * @return AjaxResult
     */
    public static AjaxResult error(int code, String msg) {
        return new AjaxResult(code, msg);
    }

    /**
     * 失败响应（自定义状态码 + 消息 + 数据）
     * @param code 状态码
     * @param msg 响应消息
     * @param data 响应数据
     * @return AjaxResult
     */
    public static AjaxResult error(int code, String msg, Object data) {
        return new AjaxResult(code, msg, data);
    }
}
