package com.noexp.timebank.entity;

import com.noexp.timebank.annotation.ServeStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.util.Date;

/**
 * @author gefangjie
 */
// 这是用户发起服务需求的类
@Data
@NoArgsConstructor
@ToString
public class ServeNeed {
    // 服务需求的ID：举例：1
    private int needId;
    // 服务时长：举例：2小时
    @NotNull
    private Time time;
    // 服务需求的标题：举例：帮忙搬家
    @NotEmpty
    private String content;
    // 服务需求的详细描述：举例：帮忙搬家，家里有一些家具需要搬到新家，需要帮忙的朋友联系我
    @NotEmpty
    private String details;
    // 服务需求的发起者ID：举例：1
    @NotNull
    private int userId;
    // 服务的需求时间范围：举例：2021-06-01 12:00:00到2021-06-01 14:00:00
    private Date startTime;
    private Date endTime;
    // 服务需求的地点：举例：北京市海淀区中关村
    @NotEmpty
    private String location;
    // 服务需求的提交时间：举例：2021-06-01 10:00:00
    private Date submitTime;
    // 服务需求的属性：举例：搬家
    @NotEmpty
    private String attribute;
    // 服务需求的状态：有审核中、待接受、已接受、已完成、已取消、已过期等状态
    @ServeStatus
    private String status;
    // 配图：举例：图片的URL
    private String needPic;
    // 服务需求的赏金：举例：10$
    @NotNull
    private double account;
}
