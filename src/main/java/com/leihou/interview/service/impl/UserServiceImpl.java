package com.leihou.interview.service.impl;

import com.leihou.interview.entity.User;
import com.leihou.interview.mapper.UserMapper;
import com.leihou.interview.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int createUser(User user) {
        return userMapper.insert(user);
    }
}
