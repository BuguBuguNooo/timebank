package com.noexp.timebank.service.Impl;

import com.noexp.timebank.entity.ServeOrder;
import com.noexp.timebank.mapper.ServeOrderMapper;
import com.noexp.timebank.service.ServeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeOrderServiceImpl implements ServeOrderService {

    @Autowired
    private ServeOrderMapper serveOrderMapper;
    @Override
    public int addServeOrder(int provideId, int needId) {
        return serveOrderMapper.addServeOrder(provideId, needId);
    }

    @Override
    public int deleteServeOrderById(Integer orderId) {
        return serveOrderMapper.deleteServeOrderById(orderId);
    }

    @Override
    public ServeOrder queryServeOrderById(Integer orderId) {
        return serveOrderMapper.queryServeOrderById(orderId);
    }

    @Override
    public int updateServeOrderByAcceptId(ServeOrder serveOrder) {
        return serveOrderMapper.updateServeOrderByAcceptId(serveOrder);
    }
}
