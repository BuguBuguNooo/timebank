package com.noexp.timebank.mapper;

import com.noexp.timebank.entity.ServeOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface ServeOrderMapper {
    //新增一个订单
    int addServeOrder(@Param("serveOrderId") int serveOrderId, int needId);
    //根据订单ID删除一个订单
    int deleteServeOrderById(Integer orderId);
    //根据订单ID更新一个订单
    int updateServeOrderById(ServeOrder serveOrder);
    //根据订单ID查询一个订单
    ServeOrder queryServeOrderById(Integer orderId);
    //根据用户（接单者）ID查询订单
    List<ServeOrder> queryServeOrderByGetId(Integer getId);
}
