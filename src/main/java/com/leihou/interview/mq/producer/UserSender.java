package com.leihou.interview.mq.producer;

import com.leihou.interview.entity.User;
import com.leihou.interview.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void sendCreateUser(User user) {
//        log.info("发送消息：" + JsonUtil.toJson(user));
        this.rabbitTemplate.convertAndSend("user.create", JsonUtil.toJson(user));
    }
}
