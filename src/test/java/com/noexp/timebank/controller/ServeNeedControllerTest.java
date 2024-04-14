package com.noexp.timebank.controller;

import com.noexp.timebank.entity.Result;
import com.noexp.timebank.entity.ServeNeed;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServeNeedControllerTest {

    @Autowired
    private ServeNeedController serveNeedController;

    @Test
    void addServeNeed() {
        //生成20个随机的服务需求
        // 创建一个表示时间的 java.sql.Time 对象
        Time time = Time.valueOf("02:00:00");
        for (int i = 0; i < 20; i++) {
            ServeNeed serveNeed = new ServeNeed();
            serveNeed.setUserId(1);
            serveNeed.setTime(time);
            serveNeed.setContent("服务需求" + i);
            serveNeed.setDetails("服务需求内容" + i);
            serveNeed.setAttribute("服务需求类型" + i);
            serveNeed.setLocation("服务需求地点" + i);
            serveNeed.setStartTime(new Date());
            serveNeed.setEndTime(new Date());
            serveNeed.setAccount(20);
            Result<String> result = serveNeedController.addServeNeed(serveNeed);
            assertEquals("服务需求发起成功!", result.getData());
        }
    }
}