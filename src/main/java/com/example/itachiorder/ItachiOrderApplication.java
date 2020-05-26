package com.example.itachiorder;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//注册到服务治理中心
@EnableDiscoveryClient
//使用feign声明式服务调用
@EnableFeignClients
//服务降级 熔断
@EnableCircuitBreaker
//tx-lcn client端
@EnableDistributedTransaction
@MapperScan("com.example.itachiorder.mapper")
public class ItachiOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItachiOrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
