package com.noexp.timebank.service;

import com.noexp.timebank.entity.Notice;
import com.noexp.timebank.entity.User;

import java.util.List;

/**
 * @author gefangjie
 */
public interface NoticeService {
    //新增系统公告
    int addNotice(Notice notice);
    //删除系统公告
    int deleteNotice(int noticeId);
    //修改系统公告
    int updateNotice(Notice notice);
    //查询所有系统公告
    List<Notice> findAllNotice();
    //查询最新的系统公告
    Notice findNewNotice();
}
