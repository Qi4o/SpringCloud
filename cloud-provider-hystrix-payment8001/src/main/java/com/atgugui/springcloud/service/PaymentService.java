package com.atgugui.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author Qiao
 * @Create 2022/8/12 11:47
 */

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "\t" + "😀";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int a = 10 / 0;
//        int timeNumber = 5;
//        try{ TimeUnit.SECONDS.sleep(timeNumber); } catch (Exception e) { e.printStackTrace(); }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_Timeout, id: " + id + "\t" + "😀" + "耗时: ";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeoutHandler, id: " + id + "\t" + "🙈";
    }

    //服务熔断======
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("*****id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试 id" + id;
    }

}
