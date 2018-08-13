package com.leihou.interview.service.impl;

import com.leihou.interview.entity.User;
import com.leihou.interview.mapper.UserMapper;
import com.leihou.interview.mq.producer.UserSender;
import com.leihou.interview.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserSender userSender;

    @Override
    public int createUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int highConcurrencyCreate(User user) {
        userSender.sendCreateUser(user);
        return 1;
    }
}
