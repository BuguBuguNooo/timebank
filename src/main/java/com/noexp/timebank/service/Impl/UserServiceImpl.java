package com.noexp.timebank.service.Impl;

import com.noexp.timebank.entity.User;
import com.noexp.timebank.mapper.UserMapper;
import com.noexp.timebank.service.UserService;
import com.noexp.timebank.util.Md5Util;
import com.noexp.timebank.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author gefangjie
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        //根据用户名查询用户
        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
        //加密处理
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username, md5String);
    }

    @Override
    public void update(User user) {
        //获取当前时间
        user.setUpdateTime(LocalDateTime.now());
        //更新用户信息
        userMapper.update(user);
    }

    @Override
    public void updateAvatarUrl(String userPic) {
        //从ThreadLocal中获取用户id
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("userId");
        //根据用户id更新头像
        userMapper.updateAvatarUrl(userPic, id);
    }

    @Override
    public void updatePwd(String password) {
        //从ThreadLocal中获取用户id
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("userId");
        //加密处理
        String md5String = Md5Util.getMD5String(password);
        //根据用户id更新密码
        userMapper.updatePwd(md5String, id);
    }

    //更改用户类型
    @Override
    public int updateRole(String role, Integer userId) {
        return userMapper.updateRole(role, userId);
    }

    @Override
    public Double findAccountByUserId(Integer userId) {
        return userMapper.findAccountByUserId(userId);
    }
}
