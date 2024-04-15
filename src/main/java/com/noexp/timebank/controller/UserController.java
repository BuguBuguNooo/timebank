package com.noexp.timebank.controller;

import com.noexp.timebank.annotation.UserRole;
import com.noexp.timebank.entity.Result;
import com.noexp.timebank.entity.ServeOrder;
import com.noexp.timebank.service.UserService;
import com.noexp.timebank.util.JwtUtil;
import com.noexp.timebank.util.Md5Util;
import com.noexp.timebank.util.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.noexp.timebank.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author gefangjie
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //注册
    @PostMapping("/register")
    public Result<String> register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //查询用户
        User u = userService.findByUserName(username);
        if(u == null){
            //未占用，注册
            userService.register(username, password);
            return Result.success("注册成功");
        }else{
            //占用
            return Result.error("用户名已被占用哦～");
        }
    }

    //登录
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        //根据用户名查询用户
        User loginuser = userService.findByUserName(username);
        //判断是否查询到
        if (loginuser==null){
            return Result.error("用户名错误");
        }
        //判断密码对否
        if(Md5Util.getMD5String(password).equals(loginuser.getPassword())){
            //登录成功
            Map<String, Object> claims = new HashMap<>();
            //将用户ID存入claims
            claims.put("userId", loginuser.getUserId());
            //将用户名存入claims
            claims.put("username", loginuser.getUsername());
            //将用户角色存入claims
            claims.put("role", loginuser.getRole());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        //根据用户名查询用户
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User u = userService.findByUserName(username);
        return Result.success(u);
    }
    @PutMapping("/update")
    public Result<String> update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success("更新成功");
    }

    @PatchMapping("/updateAvatar")
    public Result<String> updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatarUrl(avatarUrl);
        return Result.success("更新成功");
    }

    @PatchMapping("/updatePwd")
    public Result<String> updatePwd(@RequestBody Map<String, String> params){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if(Stream.of(oldPwd, newPwd, rePwd).anyMatch(StringUtils::isEmpty)){
            return Result.error("缺少必要的参数");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if(loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            if(newPwd.equals(rePwd)){
                //更新密码
                userService.updatePwd(newPwd);
                return Result.success();
            }else{
                return Result.error("两次密码不一致");
            }
        }else{
            return Result.error("原密码错误");
        }
    }

    //超级管理员可以更改用户类型：任命为管理员，撤销管理员
    @PatchMapping("/updateRole")
    public Result<String> updateRole(@RequestParam @UserRole String role, @RequestParam Integer userId){
        //检查当前用户类型是否为超级管理员
        Map<String, Object> map = ThreadLocalUtil.get();
        String userRole = (String) map.get("role");
        if (!"超级管理员".equals(userRole)){
            System.out.println("我是傻逼" + userRole);
            return Result.error("权限不足");
        } else {
            //更新用户类型
            int i = userService.updateRole(role, userId);
            if(i == 1){
                return Result.success("更新成功");
            }else{
                return Result.error("更新失败");
            }
        }
    }

    //根据用户ID查看账户信息
    @GetMapping("/findAcByUserId")
    public Result<Double> findAccountByUserId(){
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        return Result.success(userService.findAccountByUserId(userId));
    }

    //查询用户接到的所有订单
    @GetMapping("/getMyServeOrder")
    public Result<List<ServeOrder>> queryServeOrderByUserId(){
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("userId");
        return Result.success(userService.queryServeOrderByUserId(userId));
    }
}
