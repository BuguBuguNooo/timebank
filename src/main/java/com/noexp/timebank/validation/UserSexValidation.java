package com.noexp.timebank.validation;


import com.noexp.timebank.annotation.UserSex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author gefangjie
 */ //ConstraintValidator<给哪个注解提供校验规则，校验的数据类型>
public class UserSexValidation implements ConstraintValidator<UserSex, String> {
    /**
     *
     * @param s 传入的校验数据
     * @param constraintValidatorContext
     * @return true:校验通过 false:校验失败
     */

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //校验逻辑
        if ("男".equals(s) || "女".equals(s) || "保密".equals(s)) {
            return true;
        }
        return false;
    }
}
