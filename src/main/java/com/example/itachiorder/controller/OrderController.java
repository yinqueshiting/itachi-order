package com.example.itachiorder.controller;

import com.example.itachiorder.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class OrderController {

    @Value("version")
    private String version;
    /*@Autowired
    private LoadBalancerClient loadBalancerClient;*/

    private final FeignService feignService;

    public OrderController(FeignService feignService) {
        this.feignService = feignService;
    }


    @PostMapping("addTheOrder")
    @HystrixCommand(fallbackMethod = "addTheOrderError")
    public Object addTheOrder(){
       /* ServiceInstance serviceInstance = loadBalancerClient.choose("INVENTORY");
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/deductTheInventory";*/
       /* String url = "http://INVENTORY/deductTheInventory";//ip和端口直接使用项目名称
        log.info("请求的url:{}",url);*/
       int i = 5/0;
       log.info("进入了addTheOrder");
        return feignService.addTheOrder();
    }


    public Object addTheOrderError(){

        log.info("进入了addTheOrderError----------------------");
        Map map = new HashMap<>();
        map.put("error","稍后再试");
        return map;
    }

    @GetMapping("selectVersion")
    public String selectVersion(){
        return version;
    }
}
