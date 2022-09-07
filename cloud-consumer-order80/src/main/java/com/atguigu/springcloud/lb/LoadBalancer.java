package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Qiao
 * @Create 2022/8/8 15:58
 */

public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
