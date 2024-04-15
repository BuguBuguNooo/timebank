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
    //根据订单ID更新一个订单
    int updateServeOrderById(ServeOrder serveOrder);
    //根据订单ID查询一个订单
    ServeOrder queryServeOrderById(Integer orderId);
}
