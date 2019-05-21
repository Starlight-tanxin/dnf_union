package com.tx.union.core;

/**
 * 统一返回code
 *
 * @author tanxin
 * @date 2019/5/16
 */
public enum Status {
    /**
     * 默认成功
     */
    SUCCESS(200, "OK"),
    /**
     * 普通错误
     */
    REQUEST_BAD(400, "普通错误"),
    /**
     * 参数丢失
     */
    PARAM_LOST(401, "参数丢失"),
    /**
     * 没有授权
     */
    UNAUTHORIZED(402, "没有授权"),
    /**
     * 没有权限访问
     */
    FORBIDDEN(403, "没有权限访问");


    private Integer status;

    private String message;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    Status(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
