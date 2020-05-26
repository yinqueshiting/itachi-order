package com.example.itachiorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(value = "INVENTORY")
public interface FeignService {

    @GetMapping("deductTheInventory/{userId}")
    Map addTheOrder(@PathVariable String userId);
}
