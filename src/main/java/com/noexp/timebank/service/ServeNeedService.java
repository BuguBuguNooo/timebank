package com.noexp.timebank.service;

import com.noexp.timebank.entity.ServeNeed;

import java.util.Date;
import java.util.List;

/**
 * @author gefangjie
 */
public interface ServeNeedService {
    //发起服务需求
    int addServeNeed(ServeNeed serveNeed);
    //更新服务需求
    int updateServeNeed(ServeNeed serveNeed);
    //删除服务需求
    int deleteServeNeed(int needId);
    //根据服务需求ID查询服务需求
    ServeNeed getServeNeedById(int needId);
    //查询所有服务需求
    List<ServeNeed> getAllServeNeeds();
    //根据用户ID查询其发起的服务需求
    List<ServeNeed> getServeNeedsByUserId(int userId);
    //根据服务需求的状态查询服务需求
    List<ServeNeed> getServeNeedsByStatus(String status);
    //根据服务需求的属性查询服务需求
    List<ServeNeed> getServeNeedsByAttribute(String attribute);
    //根据服务需求的地点查询服务需求
    List<ServeNeed> getServeNeedsByLocation(String location);
    //根据服务需求的时间查询服务需求
    List<ServeNeed> getServeNeedsByTime(Date startTime, Date endTime);
    //修改服务需求状态
    int updateServeNeedStatus(String status, int needId);
}
