package com.tx.union.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.union.dao.AdminMapper;
import com.tx.union.pojo.dto.AdminDTO;
import com.tx.union.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author tanxin
 * @date 2019/5/15
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Page<Map<String, Object>> list(Page<Map<String, Object>> page) {
        //adminMapper.selectAdminRole(page);
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        return page.setRecords(adminMapper.selectAdminRole(page));
    }

    @Override
    public List<AdminDTO> listAdminRolePrivilege() {
        return adminMapper.selectAdminRolePrivilege();
    }
}
