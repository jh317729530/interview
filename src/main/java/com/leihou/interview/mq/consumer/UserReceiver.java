package com.leihou.interview.mq.consumer;

import com.leihou.interview.entity.User;
import com.leihou.interview.mapper.UserMapper;
import com.leihou.interview.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@RabbitListener(queues = "user.create")
public class UserReceiver {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @RabbitHandler
    public void createUser(String msg) {
        log.info("接受到创建用户消息：" + msg);

        if (StringUtils.isNotBlank(msg)) {
            User user = JsonUtil.fromJson(msg, User.class);
            userMapper.insert(user);
        }

    }
}
