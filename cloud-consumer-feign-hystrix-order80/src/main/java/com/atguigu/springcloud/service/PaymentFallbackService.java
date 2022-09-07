package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author Qiao
 * @Create 2022/8/29 11:17
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo_TimeOut";
    }
}
