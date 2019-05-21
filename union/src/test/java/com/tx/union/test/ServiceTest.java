package com.tx.union.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tx.union.pojo.entity.Role;
import com.tx.union.pojo.entity.User;
import com.tx.union.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * @author tanxin
 * @date 2019/5/16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void testAdd() {
        Role role = Role.builder()
                .roleName("帖子管理员3")
                .isDeleted(null)
                .description("管理帖子的删除")
                .createdTime(LocalDateTime.now())
                .lastUpdateTime(LocalDateTime.now())
                .build();
        roleService.save(role);
        log.info("\t ID : " + role.getId());
    }

    @Test
    public void testList() {
        // 使用实力
        Role r = Role.builder().build();
        IPage<Role> page = roleService.page(new Page<Role>(2,2), Wrappers.query(new Role()).likeRight("role_name","帖子"));
//        IPage<Role> page = roleService.page(new Page<>(1, 2), Wrappers.query(
//                Role.builder()
//                        .roleName("帖子")
//                        .description("管理")
//                        .build()
//        ));
        page.getRecords().forEach(role -> {
            log.info(role.getId().toString());
            log.info(role.getRoleName());
        });
    }

    @Test
    public void testUpdate(){
        roleService.updateById(Role.builder().id(3).roleName("帖子超级管理").lastUpdateTime(LocalDateTime.now()).build());
    }
}
