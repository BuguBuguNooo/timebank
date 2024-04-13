package com.noexp.timebank.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gefangjie
 */ //统一响应结果
@NoArgsConstructor//这个注解表示生成一个无参构造方法
@AllArgsConstructor//这个注解表示生成一个全参构造方法
@Data//这个注解表示生成get、set方法
public class Result<T> {
    //业务状态码  0-成功  1-失败
    private Integer code;
    //提示信息
    private String message;
    //响应数据
    private T data;
    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }
    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(0, "操作成功", null);
    }
    //快速返回操作失败响应结果
    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
