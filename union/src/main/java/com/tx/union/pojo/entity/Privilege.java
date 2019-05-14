package com.tx.union.pojo.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限表
 * @author tanxin
 * @date 2019/5/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Privilege implements Serializable {

    private static final long serialVersionUID = -1284882842700053057L;

    Integer id;

    String name;

    String url;

    Boolean isDeleted;

    LocalDateTime createdTime;

    LocalDateTime lastUpdateTime;
}
