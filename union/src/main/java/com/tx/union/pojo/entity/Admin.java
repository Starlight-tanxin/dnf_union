package com.tx.union.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author tanxin
 * @since 2019-05-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    private String password;

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
