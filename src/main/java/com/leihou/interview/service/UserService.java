package com.leihou.interview.service;

import com.leihou.interview.entity.User;

public interface UserService {

    int createUser(User user);

    int highConcurrencyCreate(User user);
}
