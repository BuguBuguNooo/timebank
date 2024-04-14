package com.noexp.timebank.service;

import com.noexp.timebank.entity.User;

/**
 * @author gefangjie
 */
public interface UserService {
    //根据用户名查询用户
    User findByUserName(String username);
    //注册用户
    void register(String username, String password);
    //更新用户信息
    void update(User user);
    //更新头像
    void updateAvatarUrl(String userPic);
    //更新密码
    void updatePwd(String password);
    //更改用户类型
    int updateRole(String role, Integer userId);
    //根据用户ID查看账户信息
    Double findAccountByUserId(Integer userId);
}
