package com.noexp.timebank.service.Impl;

import com.noexp.timebank.entity.Notice;
import com.noexp.timebank.entity.User;
import com.noexp.timebank.mapper.NoticeMapper;
import com.noexp.timebank.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gefangjie
 */
@Service
public class NoticeMapperImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }

    @Override
    public int deleteNotice(int noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public List<Notice> findAllNotice() {
        return noticeMapper.findAllNotice();
    }

    @Override
    public Notice findNewNotice() {
        return noticeMapper.findNewNotice();
    }
}
