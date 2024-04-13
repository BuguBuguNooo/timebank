package com.noexp.timebank.annotation;

import com.noexp.timebank.validation.UserSexValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * @author gefangjie
 */
@Documented//元注解，用于描述注解的使用范围
@Constraint(
        validatedBy = {UserSexValidation.class}//指定校验逻辑的类
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserSex {
    //提供校验失败后的提示信息
    String message() default "性别要是男、女或保密";
    //指定分组
    Class<?>[] groups() default {};
    //指定负载 获取到state的附加信息
    Class<? extends Payload>[] payload() default {};
}