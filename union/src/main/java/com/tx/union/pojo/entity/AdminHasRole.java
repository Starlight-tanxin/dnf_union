package com.tx.union.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员对应角色表
 * </p>
 *
 * @author tanxin
 * @since 2019-05-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_has_role")
public class AdminHasRole extends Model<AdminHasRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 角色id
     */
    private Integer roleId;


}
