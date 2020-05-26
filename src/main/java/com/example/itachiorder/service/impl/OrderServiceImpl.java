package com.example.itachiorder.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.example.itachiorder.mapper.OrderMapper;
import com.example.itachiorder.service.FeignService;
import com.example.itachiorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final FeignService feignService;

    public OrderServiceImpl(FeignService feignService) {
        this.feignService = feignService;
    }

    @Resource
    private OrderMapper orderMapper;

    @Override
    @LcnTransaction
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Map addTheOrder(String userId) {
        //先执行订单加一
        log.info("开始执行添加订单");
        orderMapper.addTheOrder(userId,1);

        //调用库存服务
        log.info("开始执行扣除库存");
        Map resMap = feignService.addTheOrder(userId);

        //模拟异常
        int i = 5/0;
        return resMap;
    }
}
