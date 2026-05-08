package com.fast.logintest.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 17:46
 * @Version: 1.0
 */
@Data
public class RegisterDTO {
    @NotBlank(message="用户名不为空")
    @Size(min=3, max=20, message="用户名长度在3-20之间")
    private String username;

    @NotBlank(message="密码不为空")
    @Size(min=6, max=20, message="密码长度在6-20之间")
    private String password;
}
