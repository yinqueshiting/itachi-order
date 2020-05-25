package com.example.itachiorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(value = "INVENTORY")
public interface FeignService {

    @PostMapping("deductTheInventory")
    Map addTheOrder();
}
