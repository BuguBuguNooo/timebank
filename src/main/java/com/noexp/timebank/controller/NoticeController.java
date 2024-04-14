package com.noexp.timebank.controller;

import com.noexp.timebank.entity.Notice;
import com.noexp.timebank.entity.Result;
import com.noexp.timebank.service.NoticeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    //新增系统公告
    @RequestMapping("/addNotice")
    public Result<String> addNotice(@RequestBody @Validated Notice notice) {
        int res =  noticeService.addNotice(notice);
        if (res == 1) {
            return Result.success("新增成功");
        } else {
            return Result.error("新增失败");
        }
    }
    //删除系统公告
    @RequestMapping("/deleteNotice")
    public Result<String> deleteNotice(@Valid int noticeId) {
        int res =  noticeService.deleteNotice(noticeId);
        if (res == 1) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }
    //修改系统公告
    @RequestMapping("/updateNotice")
    public Result<String> updateNotice(@RequestBody @Validated Notice notice) {
        int res =  noticeService.updateNotice(notice);
        if (res == 1) {
            return Result.success("修改成功");
        } else {
            return Result.error("修改失败");
        }
    }
    //查找所有系统公告
    @RequestMapping("/findAllNotice")
    public Result findAllNotice() {
        return Result.success(noticeService.findAllNotice());
    }
    //查找最新系统公告
    @RequestMapping("/findNewNotice")
    public Result findNewNotice() {
        return Result.success(noticeService.findNewNotice());
    }

}
