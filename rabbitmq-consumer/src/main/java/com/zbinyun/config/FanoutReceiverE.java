package com.zbinyun.config;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component

public class FanoutReceiverE {

    @RabbitListener(queuesToDeclare=@Queue("fanout.E"))
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverE消费者收到消息  : " +testMessage.toString());
    }
}
