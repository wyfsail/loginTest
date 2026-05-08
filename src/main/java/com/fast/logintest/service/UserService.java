package com.fast.logintest.service;



import com.fast.logintest.domain.AjaxResult;
import com.fast.logintest.domain.User;
import com.fast.logintest.dto.LoginDTO;
import com.fast.logintest.dto.RegisterDTO;
import com.fast.logintest.dto.UpdateDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 11:43
 * @Version: 1.0
 */
public interface UserService {

    // 学习标记：这个方法是 Service 对 Mapper 查询能力的封装，供业务层内部复用。
    User selectUserByUsername(String username);

    // 学习标记：注册业务入口。
    AjaxResult register(RegisterDTO dto);

    // 学习标记：登录业务入口。
    AjaxResult login(LoginDTO dto);

    // 学习标记：修改密码业务入口。
    AjaxResult updatePwd(UpdateDTO dto);
}
