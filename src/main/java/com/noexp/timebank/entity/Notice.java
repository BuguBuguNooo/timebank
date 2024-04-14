package com.noexp.timebank.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

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
    @NotNull
    private int noticeId;
    // 公告标题
    @NotEmpty
    private String title;
    // 公告内容
    @NotEmpty
    private String content;
    // 公告发布时间
    private LocalDateTime createTime;
    // 公告修改时间
    private LocalDateTime updateTime;
    // 公告发布者id
    @NotNull
    private int userId;
}
