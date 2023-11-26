package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.vo.RequestOrder;
import com.example.orderservice.vo.ResponseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {
    private final Environment env;
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Order Service on Port %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@RequestBody RequestOrder orderDetails, @PathVariable String userId) {
        OrderDto orderDto = orderMapper.toDto(orderDetails, userId);
        OrderDto order = orderService.createOrder(orderDto);

        ResponseOrder responseUser = orderMapper.toResponseOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable String userId) {
        Iterable<OrderEntity> orderList = orderService.getOrdersByUserId(userId);

        return ResponseEntity.ok(orderMapper.toResponseOrderList(orderList));
    }
}
