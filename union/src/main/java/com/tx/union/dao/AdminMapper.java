package com.tx.union.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.union.pojo.dto.AdminDTO;
import com.tx.union.pojo.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author tanxin
 * @since 2019-05-15
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<Map<String, Object>> selectAdminRole(Page<Map<String, Object>> page);

    List<AdminDTO> selectAdminRolePrivilege();
}
