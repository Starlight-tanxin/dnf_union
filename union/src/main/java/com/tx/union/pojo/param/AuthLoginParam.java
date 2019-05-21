package com.tx.union.pojo.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author tanxin
 * @date 2019/5/17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthLoginParam implements Serializable {
    private static final long serialVersionUID = 1611819719624701219L;

    @NotBlank(message = "账号不能为空值")
    private String account;

    @NotBlank(message = "密码不能为空值")
    private String password;

}
