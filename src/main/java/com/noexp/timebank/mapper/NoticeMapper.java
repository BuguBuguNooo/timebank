package com.noexp.timebank.mapper;

import com.noexp.timebank.entity.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface NoticeMapper {
    //新增系统公告
    @Insert("insert into timebank.Notice(title, content, create_time, update_time, user_id) values(#{title}, #{content}, now(), now(), #{userId})")
    int addNotice(Notice notice);
    //删除系统公告
    @Delete("delete from timebank.Notice where notice_id = #{noticeId}")
    int deleteNotice(int noticeId);
    //修改系统公告
    @Update("update timebank.Notice set title = #{title}, content = #{content}, update_time = now() where notice_id = #{noticeId}")
    int updateNotice(Notice notice);
    //查询所有系统公告
    @Select("select * from timebank.Notice")
    List<Notice> findAllNotice();
    //查询最新的系统公告
    @Select("select * from timebank.Notice order by create_time desc limit 1")
    Notice findNewNotice();
}
