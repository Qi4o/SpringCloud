package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * @Author Qiao
 * @Create 2022/9/7 11:36
 */

@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    private MessageChannel output;  // 消息发送管道

    @Override
    public String send() {
        return null;
    }
}
