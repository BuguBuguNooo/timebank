package com.noexp.timebank.mapper;

import com.noexp.timebank.entity.ServeNeed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author gefangjie
 */
@Mapper
public interface ServeNeedMapper {
    /**
     * 根据服务需求ID查询服务需求信息
     * @param needId 服务需求的ID
     * @return 返回匹配的服务需求对象
     */
    ServeNeed selectServeNeedById(@Param("needId") int needId);

    /**
     * 查询所有服务需求列表
     * @return 返回所有服务需求的列表
     */
    List<ServeNeed> selectAllServeNeeds();

    /**
     * 根据用户ID查询其发起的服务需求列表
     * @param userId 用户的ID
     * @return 返回该用户发起的所有服务需求的列表
     */
    List<ServeNeed> selectServeNeedsByUserId(@Param("userId") int userId);

    /**
     * 插入新的服务需求到数据库
     * @param serveNeed 要插入的服务需求对象
     * @return 插入成功返回true，否则返回false
     */
    boolean insertServeNeed(ServeNeed serveNeed);

    /**
     * 更新服务需求的信息
     * @param serveNeed 要更新的服务需求对象
     * @return 更新成功返回true，否则返回false
     */
    boolean updateServeNeed(ServeNeed serveNeed);

    /**
     * 根据服务需求ID删除服务需求记录
     * @param needId 服务需求的ID
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteServeNeedById(@Param("needId") int needId);

    /**
     * 根据服务需求的状态查询服务需求列表
     * @param status 服务需求的状态
     * @return 返回匹配的服务需求列表
     */
    List<ServeNeed> selectServeNeedsByStatus(@Param("status") int status);

    /**
     * 根据服务需求的地点查询服务需求列表
     * @param location 服务需求的地点
     * @return 返回匹配的服务需求列表
     */
    List<ServeNeed> selectServeNeedsByLocation(@Param("location") String location);

    /**
     * 根据服务需求的提交时间范围查询服务需求列表
     * @param startTime 提交时间的开始日期
     * @param endTime 提交时间的结束日期
     * @return 返回在指定时间范围内提交的服务需求列表
     */
    List<ServeNeed> selectServeNeedsBySubmitTimeRange(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 根据服务需求的属性查询服务需求列表
     * @param attribute 服务需求的属性
     * @return 返回匹配的服务需求列表
     */
    List<ServeNeed> selectServeNeedsByAttribute(@Param("attribute") String attribute);

    /**
     * 根据服务需求的赏金范围查询服务需求列表
     * @param minAccount 赏金的最小值
     * @param maxAccount 赏金的最大值
     * @return 返回在指定赏金范围内的服务需求列表
     */
    List<ServeNeed> selectServeNeedsByAccountRange(@Param("minAccount") double minAccount, @Param("maxAccount") double maxAccount);

    // 可以根据实际需求继续添加其他查询、更新、删除等方法
}