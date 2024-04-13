package com.noexp.timebank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author gefangjie
 */
// 超级管理员发布的系统公告类
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {
    // 公告id
    private int noticeId;
    // 公告标题
    private String noticeTitle;
    // 公告内容
    private String noticeContent;
    // 公告发布时间
    private String noticeTime;
    // 公告发布者id
    private int noticePublisherId;
    // 公告修改时间
    private String noticeModifyTime;
}
