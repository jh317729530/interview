package com.leihou.interview.controller;

import com.leihou.interview.entity.User;
import com.leihou.interview.entity.Customer;
import com.leihou.interview.mapper.CustomerMapper;
import com.leihou.interview.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private UserService userService;

    @RequestMapping("/helloworld")
    public String helloworld() {
        Customer customer = customerMapper.selectByPrimaryKey(10);



        System.out.println(customer.getData());

        return "helloworld";
    }

    @RequestMapping("create")
    public String create(@RequestParam String loginid,@RequestParam String password) {
        User user = new User();
        user.setLoginid(loginid);
        user.setPassword(password);
        user.setCreateTime(new Date());
        userService.createUser(user);
        return "200";
    }
}





