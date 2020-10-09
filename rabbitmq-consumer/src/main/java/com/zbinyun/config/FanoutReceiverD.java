package com.zbinyun.config;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queuesToDeclare=@Queue("fanout.D"))
public class FanoutReceiverD {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverD消费者收到消息  : " +testMessage.toString());
    }

    @RabbitHandler
    public void process(String testMessage) {
        System.out.println("FanoutReceiverD消费者收到消息2  : " +testMessage.toString());
    }
}
