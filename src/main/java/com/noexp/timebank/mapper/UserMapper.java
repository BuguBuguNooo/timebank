package com.noexp.timebank.mapper;

import com.noexp.timebank.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author gefangjie
 */
@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from User where username=#{username}")
    User findByUserName(String username);
    //添加用户
    @Insert("insert into User(username, password, create_time, update_time)" +
            " values(#{username}, #{password}, now(), now())")
    void add(String username, String password);
    //更新用户信息
    @Update("update User set nickname=#{nickname},sex=#{sex}, id_card=#{idCard}, location=#{location}, phone=#{phone}, email=#{email}, update_time=#{updateTime} where user_id=#{userId}")
    void update(User user);
    //更新头像
    @Update("update User set user_pic=#{userPic}, update_time=now() where user_id=#{userId}")
    void updateAvatarUrl(String userPic,Integer userId);
    //更新密码
    @Update("update User set password=#{md5String}, update_time=now() where user_id=#{userId}")
    void updatePwd(String md5String, Integer userId);
    //更改用户类型
    @Update("update User set role=#{role}, update_time=now() where user_id=#{userId}")
    int updateRole(String role, Integer userId);
    //根据用户ID查看账户信息
    @Select("select account from User where user_id=#{userId}")
    Double findAccountByUserId(Integer userId);
}
