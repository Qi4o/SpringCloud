package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Qiao
 * @Create 2022/9/7 16:18
 */

@EnableBinding(Source.class)    //定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;


    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial: " + serial);
        return null;
    }
}
