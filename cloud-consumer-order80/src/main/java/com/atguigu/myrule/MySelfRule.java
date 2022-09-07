package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Qiao
 * @Create 2022/8/8 11:19
 */


@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();    //定义为随机
    }
}
