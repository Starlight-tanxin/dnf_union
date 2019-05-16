package com.tx.union.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * @author tanxin
 * @date 2019/5/15
 */
public interface AuthService {


    Page<Map<String,Object>> list(Page<Map<String,Object>> page);
}
