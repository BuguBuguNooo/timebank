package com.noexp.timebank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author gefangjie
 */ // 这是审核表的类
@Data
@NoArgsConstructor
public class Check {
    // 审核ID
    private Integer checkId;
    // 服务ID
    private Integer serveId;
    // 审核人ID
    private Integer checkManId;
    // 审核状态
    private String status;
    // 审核时间
    private Date time;
    // 审核意见
    private String opinion;
}
