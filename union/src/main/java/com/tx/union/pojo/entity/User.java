package com.tx.union.pojo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表
 *
 * @author tanxin
 * @date 2019/5/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {

    private static final long serialVersionUID = 7687953172098915048L;

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     * 0 - 女
     * 1 - 男
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 激活状态
     * 0 - 未激活
     * 1 - 激活
     */
    private Boolean activation;

    /**
     * 是否删除
     * 0 - 否
     * 1 - 是
     */
    private Boolean isDeleted;

    private LocalDateTime createdTime;

    private LocalDateTime lastUpdateTime;
}
