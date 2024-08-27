package com.example.microservicios_order.dtos;

import com.example.microservicios_order.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto toDto(Order order);
    Order toEntity(OrderDto orderDto);

    Order saveDtoToEntity(OrderToSaveDto orderToSaveDto);
}
