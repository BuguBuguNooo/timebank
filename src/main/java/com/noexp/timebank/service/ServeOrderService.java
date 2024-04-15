package com.noexp.timebank.service;

import com.noexp.timebank.entity.ServeOrder;

/**
 * @author gefangjie
 */
public interface ServeOrderService {
    //新增一个订单
    int addServeOrder(int provideId, int needId);
    //根据订单ID删除一个订单
    int deleteServeOrderById(Integer orderId);
    //根据订单ID查询一个订单
    ServeOrder queryServeOrderById(Integer orderId);
    //接单者修改：订单状态（已完成），评价，附图（如有），附件（如有），确认金额
    int updateServeOrderByAcceptId(ServeOrder serveOrder);
}
