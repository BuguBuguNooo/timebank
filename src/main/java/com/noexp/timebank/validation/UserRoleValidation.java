package com.noexp.timebank.validation;

import com.noexp.timebank.annotation.UserRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author gefangjie
 */
public class UserRoleValidation implements ConstraintValidator<UserRole, String> {
    /**
     *
     * @param s 传入的校验数据
     * @return true:校验通过 false:校验失败
     */

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //校验逻辑
        return "普通用户".equals(s) || "管理员".equals(s) || "超级管理员".equals(s);
    }
}
