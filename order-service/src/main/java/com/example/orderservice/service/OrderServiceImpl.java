package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements orderService {
    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDetails) {
        orderDetails.setOrderId(UUID.randomUUID().toString());
        orderDetails.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());
        OrderEntity orderEntity = orderMapper.toOrderEntity(orderDetails);

        repository.save(orderEntity);

        return orderMapper.toOrderDto(orderEntity);
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity orderEntity = repository.findByOrderId(orderId);
        return orderMapper.toOrderDto(orderEntity);
    }

    @Override
    public Iterable<OrderEntity> getOrderByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
