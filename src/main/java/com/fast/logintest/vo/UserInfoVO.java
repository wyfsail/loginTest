package com.fast.logintest.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 学习标记：这是返回给前端的用户信息对象。
 * 企业项目里，不建议把数据库实体 User 直接返回给前端，
 * 这样可以避免把 password 这类敏感字段带出去。
 */
@Data
public class UserInfoVO {
    private Long userId;
    private String userName;
    private Integer gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
