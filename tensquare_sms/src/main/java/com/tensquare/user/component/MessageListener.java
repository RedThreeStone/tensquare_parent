package com.tensquare.user.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class MessageListener {

    @RabbitHandler
    public void handlerSms(Map msg){
        System.out.println("收到信息了"+msg);
    }
}
