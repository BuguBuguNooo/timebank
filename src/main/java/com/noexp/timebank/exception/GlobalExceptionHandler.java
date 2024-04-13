package com.noexp.timebank.exception;

import com.noexp.timebank.entity.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author gefangjie
 */
//全局异常处理
@RestControllerAdvice
public class GlobalExceptionHandler {
    //处理所有异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage():"操作失败");
    }
}
