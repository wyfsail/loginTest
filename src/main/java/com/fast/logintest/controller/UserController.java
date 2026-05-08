package com.fast.logintest.controller;


import com.fast.logintest.domain.AjaxResult;
import com.fast.logintest.dto.LoginDTO;
import com.fast.logintest.dto.RegisterDTO;
import com.fast.logintest.dto.UpdateDTO;
import com.fast.logintest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 文玉帆
 * @Description: TODO
 * @Date: 2026/5/6 13:04
 * @Version: 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")  // 统一前缀
public class UserController extends BaseController {
    private final UserService userService;

    @GetMapping
    public AjaxResult home() {
        return
                AjaxResult.success("恭喜你，成功启动后端");
    }

    // 学习标记：Controller 层只负责接收参数、调用 Service、返回结果，不写具体业务逻辑。
    @PostMapping("/login")
    public AjaxResult login(@RequestBody @Valid LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    // 学习标记：注册接口只接 DTO，再把真正业务交给 Service 去处理。
    @PostMapping("/register")
    public AjaxResult register(@RequestBody @Valid RegisterDTO dto) {

        return userService.register(dto);
    }

    // 学习标记：修改密码接口同理，Controller 不直接操作数据库。
    @PostMapping("/update")
    public AjaxResult update(@RequestBody @Valid UpdateDTO updateDTO) {
        return userService.updatePwd(updateDTO);
    }

}
