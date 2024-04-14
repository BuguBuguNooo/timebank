package com.noexp.timebank.annotation;

import com.noexp.timebank.validation.ServeStatusValidation;
import com.noexp.timebank.validation.UserRoleValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author gefangjie
 */
@Documented//元注解，用于描述注解的使用范围
@Constraint(
        validatedBy = {ServeStatusValidation.class}//指定校验逻辑的类
)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ServeStatus {
    //提供校验失败后的提示信息
    String message() default "服务需求的状态：有审核中、待接受、已接受、已完成、已取消、已过期等状态!";
    //指定分组
    Class<?>[] groups() default {};
    //指定负载 获取到state的附加信息
    Class<? extends Payload>[] payload() default {};
}
