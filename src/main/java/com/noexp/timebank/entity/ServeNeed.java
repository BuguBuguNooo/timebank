package com.noexp.timebank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author gefangjie
 */
// 这是用户发起服务需求的类
@Data
@NoArgsConstructor
@ToString
public class ServeNeed {
    // 服务需求的ID
    private int needId;
    // 服务需求的时间长度
    private Date time;
    // 服务需求的标题
    private String content;
    // 服务需求的详细描述
    private String details;
    // 服务需求的发起者ID
    private int userId;
    private String duration;
    // 服务需求的地点
    private String location;
    // 服务需求的提交时间
    private Date submitTime;
    private String attribute;
    // 服务需求的状态
    private int status;
    private String application;
    private double account;
}
