package com.noexp.timebank.controller;

import com.noexp.timebank.entity.Result;
import com.noexp.timebank.entity.ServeOrder;
import com.noexp.timebank.service.ServeNeedService;
import com.noexp.timebank.service.ServeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/serveOrder")
public class ServeOrderController {

    private final ServeOrderService serveOrderService;
    private final ServeNeedService serveNeedService;

    @Autowired
    public ServeOrderController(ServeOrderService serveOrderService, ServeNeedService serveNeedService) {
        this.serveOrderService = serveOrderService;
        this.serveNeedService = serveNeedService;
    }

    //用户完成订单内容，修改订单表信息：
    //添加：接单者自我评价，接单者配图（如有），接单者附件（如有）,接单者确认金额
    //在ServeNeed表修改服务状态
    @PatchMapping("/serveOrder")
    @Transactional(rollbackFor = Exception.class)
    public Result<String> completeOrder(@Validated @RequestBody ServeOrder serveOrder){
        //修改订单表信息
        try {
            // 修改订单表信息
            int updateOrderResult = serveOrderService.updateServeOrderByAcceptId(serveOrder);
            if (updateOrderResult == 1) {
                // 在ServeNeed表修改服务状态
                int updateServeNeedResult = serveNeedService.updateServeNeedStatus("已完成", serveOrder.getServeOrderId());
                if (updateServeNeedResult == 1) {
                    // 两个数据库操作都成功
                    return Result.success("订单完成成功!");
                } else {
                    // 修改服务状态失败
                    return Result.error("修改服务状态失败，请重试");
                }
            } else {
                // 修改订单信息失败
                return Result.error("修改订单信息失败，请重试");
            }
        } catch (Exception e) {
            // 记录日志或进行异常处理
            e.printStackTrace();
            return Result.error("服务器内部错误，订单完成失败");
        }
    }
}
