package com.fast.logintest.mapper;


import com.fast.logintest.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 11:28
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
     User selectUserByUsername(@Param("username") String username);

    /**
     * 新增用户
     * 作用：注册保存新用户
     * 返回值：受影响的行数
     */
    int insertUser(User user);
    int updateUser(User user);
}
