package com.tx.union.secruity;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tx.union.dao.AdminMapper;
import com.tx.union.pojo.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author tanxin
 * @date 2019/5/17
 */
@Slf4j
@Component
public class LoginAuthProvider implements AuthenticationProvider {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        log.info("name : {}" ,name);
        String account = (String) authentication.getPrincipal();
        log.info("account : {}" ,account);
        String password = (String) authentication.getCredentials();
        log.info("password : {}" ,password);
        Admin admin = adminMapper.selectOne(Wrappers.query(Admin.builder().username(name).build()));
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
