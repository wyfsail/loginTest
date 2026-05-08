package com.fast.logintest.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 11:07
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;        // 用户ID
    private String userName;    // 用户名称
    private String nickName;    // 昵称
    private String password;    // 密码
    private Integer gender;     // 性别 0-未知 1-男 2-女
    private String avatar;      // 头像（修正了你的avater拼写）

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;    // 创建时间（修正了你的Data为Date）

}
