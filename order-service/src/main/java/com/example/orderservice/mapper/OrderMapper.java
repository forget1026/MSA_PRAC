package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.vo.RequestOrder;
import com.example.orderservice.vo.ResponseOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toEntity(OrderDto orderDetails);

    OrderDto toDto(OrderEntity entity);

    OrderDto toDto(RequestOrder entity, String userId);

    ResponseOrder toResponseOrder(OrderDto order);

    List<ResponseOrder> toResponseOrderList(Iterable<OrderEntity> order);
}
