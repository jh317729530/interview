package com.leihou.interview.mq.producer;

import com.leihou.interview.entity.User;
import com.leihou.interview.util.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void sendCreateUser(User user) {
        this.rabbitTemplate.convertAndSend("user.create", JsonUtil.toJson(user));
    }
}
