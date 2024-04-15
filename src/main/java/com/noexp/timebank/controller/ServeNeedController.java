package com.noexp.timebank.controller;

import com.noexp.timebank.annotation.ServeStatus;
import com.noexp.timebank.entity.Result;
import com.noexp.timebank.entity.ServeNeed;
import com.noexp.timebank.exception.OrderException;
import com.noexp.timebank.service.ServeNeedService;
import com.noexp.timebank.service.ServeOrderService;
import com.noexp.timebank.util.ThreadLocalUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/serveNeed")
public class ServeNeedController {

    // 日志记录
    private static final Logger logger = LoggerFactory.getLogger(ServeNeedController.class);

    private final ServeNeedService serveNeedService;
    private final ServeOrderService serveOrderService;

    @Autowired
    public ServeNeedController(ServeNeedService serveNeedService, ServeOrderService serveOrderService) {
        this.serveNeedService = serveNeedService;
        this.serveOrderService = serveOrderService;
    }

    //发起服务需求
    @PostMapping("/addServeNeed")
    public Result<String> addServeNeed(@Validated @RequestBody ServeNeed serveNeed){
        int i = serveNeedService.addServeNeed(serveNeed);
        if(i == 1){
            return Result.success("服务需求发起成功!");
        } else {
            return Result.error("服务需求发起失败!");
        }
    }
    //更新服务需求
    @PatchMapping("/updateServeNeed")
    public Result<String> updateServeNeed(@Validated @RequestBody ServeNeed serveNeed){
        int i = serveNeedService.updateServeNeed(serveNeed);
        if(i == 1){
            return Result.success("服务需求更新成功!");
        } else {
            return Result.error("服务需求更新失败!");
        }
    }
    //删除服务需求
    @DeleteMapping("/deleteServeNeed")
    public Result<String> deleteServeNeed(@Validated int needId){
        int i = serveNeedService.deleteServeNeed(needId);
        if(i == 1){
            return Result.success("服务需求删除成功!");
        } else {
            return Result.error("服务需求删除失败!");
        }
    }
    //根据服务需求ID查询服务需求
    @GetMapping("/getServeNeedById")
    public Result<ServeNeed> getServeNeedById(@RequestParam @Validated int needId){
        ServeNeed serveNeed = serveNeedService.getServeNeedById(needId);
        if(serveNeed != null){
            return Result.success(serveNeed);
        } else {
            return Result.error("服务需求不存在!");
        }
    }
    //查询所有服务需求
    @GetMapping("/getAllServeNeeds")
    public Result<List<ServeNeed>> getAllServeNeeds(){
        return Result.success(serveNeedService.getAllServeNeeds());
    }
    //根据用户ID查询其发起的服务需求
    @GetMapping("/getServeNeedsByUserId")
    public Result<List<ServeNeed>> getServeNeedsByUserId(@Validated int userId){
        return Result.success(serveNeedService.getServeNeedsByUserId(userId));
    }

    //根据服务需求的状态查询服务需求
    @GetMapping("/getServeNeedsByStatus")
    public Result<List<ServeNeed>> getServeNeedsByStatus(@Validated String status){
        return Result.success(serveNeedService.getServeNeedsByStatus(status));
    }

    //根据服务需求的属性查询服务需求
    @GetMapping("/getServeNeedsByAttribute")
    public Result<List<ServeNeed>> getServeNeedsByAttribute(@Validated String attribute){
        return Result.success(serveNeedService.getServeNeedsByAttribute(attribute));
    }

    //根据服务需求的地点查询服务需求
    @GetMapping("/getServeNeedsByLocation")
    public Result<List<ServeNeed>> getServeNeedsByLocation(@Validated String location){
        return Result.success(serveNeedService.getServeNeedsByLocation(location));
    }

    //根据服务需求的提交时间范围查询服务需求
    @GetMapping("/getServeNeedsBySubmitTime")
    public Result<List<ServeNeed>> getServeNeedsBySubmitTime(@Validated Date startTime,@Validated Date endTime){
        return Result.success(serveNeedService.getServeNeedsByTime(startTime, endTime));
    }

    //管理员可修改服务需求状态：进行审核
    @PatchMapping("/updateServeNeedStatus")
    public Result<String> updateServeNeedStatus(@RequestParam @Validated @ServeStatus String status, @RequestParam @Validated int needId){
        //查看当前用户是否为管理员
        Map<String, Object> map = ThreadLocalUtil.get();
        String userRole = (String) map.get("role");
        if (!"管理员".equals(userRole)){
            return Result.error("权限不足");
        } else {
            //更新服务需求状态
            int i = serveNeedService.updateServeNeedStatus(status, needId);
            if(i == 1){
                return Result.success("服务需求状态更新成功!");
            } else {
                return Result.error("服务需求状态更新失败!");
            }
        }
    }

    //事务处理，保证两个操作同时成功或同时失败，同时isolation设置为读已提交:保证事务提交后其他事务可见
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    //用户接单
    @PatchMapping("/getOrder")
    public Result<String> getOrder(@RequestBody @Validated ServeNeed serveNeed){
        Map<String, Object> map = ThreadLocalUtil.get();
        int userId = (int) map.get("userId");
        try {
            // 更新需求状态
            int i = serveNeedService.updateServeNeedStatusByUser(serveNeed.getNeedId());
            // 添加订单信息
            int j = serveOrderService.addServeOrder(serveNeed.getNeedId(), userId);

            // 检查操作结果
            if (i == 1 && j == 1) {
                return Result.success("接单成功!");
            } else {
                throw new OrderException("接单失败，更新需求状态或添加订单信息时出现问题。");
            }
        } catch (OrderException ex) {
            // 记录自定义异常信息
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            // 记录未知异常信息
            logger.error("接单过程中发生未知异常", ex);
            throw new OrderException("接单失败，遇到未知错误。");
        }
    }
}
