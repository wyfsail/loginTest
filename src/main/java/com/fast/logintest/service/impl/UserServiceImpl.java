package com.fast.logintest.service.impl;


import com.fast.logintest.domain.AjaxResult;
import com.fast.logintest.domain.User;
import com.fast.logintest.dto.LoginDTO;
import com.fast.logintest.dto.RegisterDTO;
import com.fast.logintest.dto.UpdateDTO;
import com.fast.logintest.exception.BusinessException;
import com.fast.logintest.mapper.UserMapper;
import com.fast.logintest.service.UserService;
import com.fast.logintest.vo.UserInfoVO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 11:46
 * @Version: 1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {

        return userMapper.selectUserByUsername(username);
    }

    // 注册
    @Override
    public AjaxResult register(RegisterDTO dto) {
        // 学习标记：Service 层负责真正业务，例如查重、组装实体、入库。
        User exist = selectUserByUsername(dto.getUsername());
        if (exist != null) {
            throw new BusinessException("用户名已存在");
        }

        User user = buildUser(dto.getUsername(), dto.getPassword());

        int rows = userMapper.insertUser(user);
        if (rows <= 0) {
            throw new BusinessException("注册失败");
        }
        return AjaxResult.success("注册成功", toUserInfoVO(user));
    }

    // 登录
    @Override
    public AjaxResult login(LoginDTO dto) {
        User user = getExistingUser(dto.getUsername());
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new BusinessException("密码错误");
        }
        return AjaxResult.success("登录成功", toUserInfoVO(user));
    }


    // 修改密码
    @Override
    public AjaxResult updatePwd(UpdateDTO dto) {
        User user = getExistingUser(dto.getUsername());

        // 学习标记：先查出现有用户，再更新需要修改的字段。
        user.setPassword(dto.getPassword());
        int rows = userMapper.updateUser(user);
        if (rows <= 0) {
            throw new BusinessException("修改失败");
        }
        return AjaxResult.success("修改成功");
    }

    /**
     * 学习标记：公共查询方法，用户不存在时统一抛业务异常。
     */
    private User getExistingUser(String username) {
        User user = selectUserByUsername(username);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        return user;
    }

    /**
     * 学习标记：组装实体的动作抽成独立方法，后面字段变多时更好维护。
     */
    private User buildUser(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setGender(0);
        user.setCreateTime(new Date());
        return user;
    }

    /**
     * 学习标记：实体转返回对象，避免把 password 等敏感字段直接暴露给前端。
     */
    private UserInfoVO toUserInfoVO(User user) {
        UserInfoVO vo = new UserInfoVO();
        vo.setUserId(user.getUserId());
        vo.setUserName(user.getUserName());
        vo.setGender(user.getGender());
        vo.setCreateTime(user.getCreateTime());
        return vo;
    }


}
