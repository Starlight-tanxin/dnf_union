package com.tx.union.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tanxin
 * @date 2019/5/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private Integer roleId;

    private String roleName;

    List<PrivilegeDTO> privilegeList;
}
