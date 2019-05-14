package com.tx.union.pojo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色表
 * @author tanxin
 * @date 2019/5/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role implements Serializable {

    private static final long serialVersionUID = 937889672341384314L;

    Integer id;

    String roleName;

    String description;

    Boolean isDeleted;

    LocalDateTime createdTime;

    LocalDateTime lastUpdateTime;
}
