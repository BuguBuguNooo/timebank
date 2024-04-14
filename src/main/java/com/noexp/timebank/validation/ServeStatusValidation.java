package com.noexp.timebank.validation;

import com.noexp.timebank.annotation.ServeStatus;
import com.noexp.timebank.annotation.UserRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author gefangjie
 */
public class ServeStatusValidation implements ConstraintValidator<ServeStatus, String> {
    /**
     *
     * @param s 传入的校验数据
     * @return true:校验通过 false:校验失败
     */
    // 服务需求的状态：有审核中、待接受、已接受、已完成、已取消、已过期等状态
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //校验逻辑
        return "审核中".equals(s) || "待接受".equals(s) || "已接受".equals(s) || "已完成".equals(s) || "已取消".equals(s) || "已过期".equals(s);
    }
}

