package com.tx.union.secruity;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Strings;
import com.tx.union.dao.AdminMapper;
import com.tx.union.pojo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tanxin
 * @date 2019/5/17
 */
@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(JwtUtils.TOKEN_HEADER);
        if (Strings.isNullOrEmpty(header)) {
            header = request.getParameter(JwtUtils.TOKEN_HEADER);
        }
        if (header != null && header.startsWith(JwtUtils.TOKEN_PREFIX)) {
            String token = header.substring(JwtUtils.TOKEN_PREFIX.length());
            String username = JwtUtils.getUsername(token);
            if (!Strings.isNullOrEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                //Integer id = JwtUtils.getUserId(token);
                Admin admin = adminMapper.selectOne(Wrappers.query(Admin.builder().username(username).build()));
                if (admin != null) {
                    JwtUser userDetails = new JwtUser();
                    if (JwtUtils.validateToken(token)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }

        }
        filterChain.doFilter(request, response);
    }
}
