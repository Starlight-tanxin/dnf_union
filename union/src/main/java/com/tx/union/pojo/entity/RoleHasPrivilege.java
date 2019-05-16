package com.tx.union.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色对应权限表
 * </p>
 *
 * @author ${author}
 * @since 2019-05-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_role_has_privilege")
public class RoleHasPrivilege extends Model<RoleHasPrivilege> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer privilegeId;

}
