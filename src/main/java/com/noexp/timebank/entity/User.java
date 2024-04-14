package com.noexp.timebank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.noexp.timebank.annotation.UserSex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
/**
 * @author gefangjie
 */
@Data
public class User {
    //用户ID
    @NotNull
    private Integer userId;
    //用户名
    private String username;
    @JsonIgnore//返回json时忽略密码这个字段
    private String password;
    //昵称
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    //角色:普通用户，管理员, 超级管理员
    private String role;
    //性别:男，女, 保密
    @UserSex
    private String sex;
    //邮箱
    @NotEmpty
    @Email
    private String email;
    //手机号
    @NotEmpty
    @Pattern(regexp = "^1[3-9]\\d{9}$")
    private String phone;
    //用户头像地址
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    //用户地址
    private String location;
    //用户身份证号
    private  String idCard;
}
