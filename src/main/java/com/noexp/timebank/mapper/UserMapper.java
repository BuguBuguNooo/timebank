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
    @Insert("insert into User(username, password, createTime, updateTime)" +
            " values(#{username}, #{password}, now(), now())")
    void add(String username, String password);
    //更新用户信息
    @Update("update User set nickname=#{nickname},idNumber=#{idNumber}, location=#{location}, phone=#{phone}, email=#{email}, updateTime=#{updateTime} where userId=#{userId}")
    void update(User user);
    //更新头像
    @Update("update User set userPic=#{avatatUrl}, updateTime=now() where userId=#{userId}")
    void updateAvatarUrl(String userPic,Integer userId);
    @Update("update User set password=#{md5String}, updateTime=now() where userId=#{userId}")
    void updatePwd(String md5String, Integer userId);
}
