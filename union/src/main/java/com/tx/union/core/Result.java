package com.tx.union.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一返回结果
 *
 * @author tanxin
 * @date 2019/5/16
 */
@Getter
@Setter
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -7119210377216793281L;

    private Integer status;

    private String message;

    private T body;

    private Result() {
    }

    private Result(Status resultCode) {
        this.status = resultCode.getStatus();
        this.message = resultCode.getMessage();
    }

    public static Result<?> success() {
        return new Result<>(Status.SUCCESS);
    }

    /**
     * 正常返回
     *
     * @param body 返回的数据
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T body) {
        Result<T> result = new Result(Status.SUCCESS);
        result.setBody(body);
        return result;
    }

    /**
     * 错误返回
     *
     * @param resultCode 错误枚举
     * @return
     */
    public static Result<?> error(Status resultCode) {
        return new Result<>(resultCode);
    }


    /**
     * 参数丢失错误
     * 自定错误message
     *
     * @param message 错误消息
     * @return
     */
    public static Result<?> paramLost(String message) {
        Result result = new Result();
        result.setStatus(Status.PARAM_LOST.getStatus());
        result.setMessage(message);
        return result;
    }

    /**
     * 普通错误
     * 自定错误message
     *
     * @param message
     * @return
     */
    public static Result<?> requestBad(String message) {
        Result result = new Result();
        result.setStatus(Status.REQUEST_BAD.getStatus());
        result.setMessage(message);
        return result;
    }
}
