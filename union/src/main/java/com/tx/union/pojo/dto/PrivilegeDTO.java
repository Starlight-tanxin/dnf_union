package com.tx.union.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tanxin
 * @date 2019/5/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeDTO {

    private Integer privilegeId;

    private String url;

    private String name;


}
