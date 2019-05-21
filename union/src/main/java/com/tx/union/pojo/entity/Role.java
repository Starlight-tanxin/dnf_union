package com.tx.union.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ${author}
 * @since 2019-05-15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_role")
public class Role extends Model<Role> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 角色名
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String roleName;

    /**
     * 角色介绍
     */
    private String description;

    /**
     * 是否删除
0 - 否
1 - 是
     */
    private Boolean isDeleted;

    @TableField(condition = SqlCondition.EQUAL)
    private LocalDateTime createdTime;

    private LocalDateTime lastUpdateTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
