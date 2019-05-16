package com.tx.union.web.controller.auth;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.union.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author tanxin
 * @date 2019/5/14
 */
@Validated
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/list")
    public Page<Map<String, Object>> list(@NotNull(message = "pageNum不能为null") Integer pageNum, @NotNull(message = "pageSize不能为null") Integer pageSize) {
        Page<Map<String, Object>> page = new Page<>(pageNum, pageSize);
        return authService.list(page);
    }

}
