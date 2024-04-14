package com.noexp.timebank.controller;

import com.noexp.timebank.entity.Result;
import com.noexp.timebank.entity.ServeNeed;
import com.noexp.timebank.service.ServeNeedService;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/serveNeed")
public class ServeNeedController {
    @Autowired
    private ServeNeedService serveNeedService;

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
    public Result<String> updateServeNeed(@Validated ServeNeed serveNeed){
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

}
