package com.fast.logintest.controller;


import com.fast.logintest.domain.AjaxResult;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 13:18
 * @Version: 1.0
 */
public class BaseController {
    public AjaxResult success() {
        return AjaxResult.success();
    }

    /*
    返回错误带消息的
     */
    public AjaxResult error() {
        return AjaxResult.error("注册失败");
    }

    /*
        返回受到影响行数的判断是否成功
        @Param rows：影响的行数
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
