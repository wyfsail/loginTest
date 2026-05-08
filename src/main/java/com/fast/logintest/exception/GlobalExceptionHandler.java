package com.fast.logintest.exception;

import com.fast.logintest.domain.AjaxResult;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * 作用：统一捕获项目中所有接口抛出的异常，统一返回格式给前端
 * 再也不用在每个 Controller 里写 try-catch 了
 */
@RestControllerAdvice  // 全局捕获异常 + 返回JSON格式
public class GlobalExceptionHandler {

    /**
     * 捕获【自定义业务异常】
     * 比如：用户不存在、密码错误、余额不足等自己抛出的异常
     */
    @ExceptionHandler(BusinessException.class)
    public AjaxResult handleBusinessException(BusinessException e) {
        // 直接返回异常里的提示信息给前端
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 捕获【@RequestBody JSON参数校验异常】
     * 如：@NotBlank、@NotNull 校验不通过时抛出
     * 常用于 POST/PUT 请求参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult handleMethodArgumentNotValidException(MethodArgumentNotValidException  e) {
        String message = e.getBindingResult().getFieldError() == null
                ? "请求参数校验失败"
                : e.getBindingResult().getFieldError().getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 捕获【表单参数绑定异常】
     * 如：GET 传参、form-data 传参校验失败
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult handleBindException(BindException e) {
        String message = e.getBindingResult().getFieldError() == null
                ? "请求参数绑定失败"
                : e.getBindingResult().getFieldError().getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 捕获【单个参数校验异常】
     * 如：@RequestParam @NotBlank 校验失败
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public AjaxResult handleConstraintViolationException(ConstraintViolationException e) {
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 捕获【所有其他异常】（兜底）
     * 系统未知异常、空指针、数据库异常等
     * 统一返回友好提示，不把详细错误暴露给前端
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) {
        return AjaxResult.error("系统异常，请稍后重试");
    }
}