package com.noexp.timebank.service.Impl;

import com.noexp.timebank.entity.ServeNeed;
import com.noexp.timebank.mapper.ServeNeedMapper;
import com.noexp.timebank.service.ServeNeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author gefangjie
 */
@Service
public class ServeNeedServiceImpl implements ServeNeedService {
    @Autowired
    private ServeNeedMapper serveNeedMapper;
    @Override
    public int addServeNeed(ServeNeed serveNeed) {
        return serveNeedMapper.insertServeNeed(serveNeed);
    }

    @Override
    public int updateServeNeed(ServeNeed serveNeed) {
        return serveNeedMapper.updateServeNeed(serveNeed);
    }

    @Override
    public int deleteServeNeed(int needId) {
        return serveNeedMapper.deleteServeNeedById(needId);
    }

    @Override
    public ServeNeed getServeNeedById(int needId) {
        return serveNeedMapper.selectServeNeedById(needId);
    }

    @Override
    public List<ServeNeed> getAllServeNeeds() {
        return serveNeedMapper.selectAllServeNeeds();
    }

    @Override
    public List<ServeNeed> getServeNeedsByUserId(int userId) {
        return serveNeedMapper.selectServeNeedsByUserId(userId);
    }

    @Override
    public List<ServeNeed> getServeNeedsByStatus(String status) {
        return serveNeedMapper.selectServeNeedByStatus(status);
    }

    @Override
    public List<ServeNeed> getServeNeedsByAttribute(String attribute) {
        return serveNeedMapper.selectServeNeedsByAttribute(attribute);
    }

    @Override
    public List<ServeNeed> getServeNeedsByLocation(String location) {
        return serveNeedMapper.selectServeNeedsByLocation(location);
    }

    @Override
    public List<ServeNeed> getServeNeedsByTime(Date startTime, Date endTime) {
        return serveNeedMapper.selectServeNeedsBySubmitTimeRange(startTime, endTime);
    }

    @Override
    public int updateServeNeedStatus(String status, int needId) {
        return serveNeedMapper.updateServeNeedStatus(needId, status);
    }

    @Override
    public int updateServeNeedStatusByUser(int needId, String status) {
        return serveNeedMapper.updateServeNeedStatusToAccepted(needId, status );
    }
}
