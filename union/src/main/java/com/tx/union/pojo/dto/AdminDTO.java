package com.tx.union.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author tanxin
 * @date 2019/5/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private Integer id;

    private String username;

    private String nickname;

    private String realName;

    private LocalDateTime createdTime;

    private LocalDateTime lastUpdateTime;

    List<RoleDTO> roleList;
}
