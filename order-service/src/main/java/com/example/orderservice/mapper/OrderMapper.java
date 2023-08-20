package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderEntity toOrderEntity(OrderDto orderDetails);

    OrderDto toOrderDto(OrderEntity orderEntity);
}
