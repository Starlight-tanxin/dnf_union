package com.tx.union.service.impl;

import com.tx.union.dao.UserMapper;
import com.tx.union.pojo.entity.User;
import com.tx.union.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanxin
 * @date 2019/5/14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> showUser() {
        return userMapper.selectList(null);
    }
}
