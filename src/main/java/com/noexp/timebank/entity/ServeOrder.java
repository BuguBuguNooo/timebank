package com.noexp.timebank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author gefangjie
 */ // 这是服务订单表的类
@Data
@NoArgsConstructor
@ToString
public class ServeOrder {
    // 服务订单的ID：举例：1
    private int serveId;
    // 服务订单ID：举例：1
    private Integer serveOrderId;
    // 服务订单的接单者ID：举例：2
    private Integer getId;
    // 服务订单的审核者ID：举例：3
    private Integer checkManId;
    // 服务订单的审核时间：举例：2021-06-01 12:00:00
    private Date checkTime;
    // 确认服务所花时间：举例：2小时
    private Time confirmTime;
    //发起者评价
    private String neededReport;
    //发起者评价配图
    private String attachedPicNeed;
    //发起者评价附件
    private String attachedFileNeed;
    //接单者自述
    private String selfReport;
    //接单者自述配图
    private String attachedPic;
    //接单者自述附件
    private String attachedFile;
    //最终确认金额
    private Double account;
    // 服务订单的状态：有进行中、待审核、已完成、已取消等状态
    private String status;
    // 服务订单的提交时间：举例：2021-06-01 10:00:00
    private LocalDateTime createTime;
    // 服务订单的更新时间：举例：2021-06-01 10:00:00
    private LocalDateTime updateTime;
}
