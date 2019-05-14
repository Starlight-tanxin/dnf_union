package com.tx.union.secruity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author tanxin
 * @date 2019/5/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtUser implements Serializable {

    private static final long serialVersionUID = -7590496728179308590L;

    Integer id;

    String username;

    String email;

    String mobile;


}
