package com.example.microservicios_order.services;

import com.example.microservicios_order.dtos.OrderDto;
import com.example.microservicios_order.dtos.OrderToSaveDto;

import java.util.List;

public interface OrderService {
    OrderDto saveOrder(OrderToSaveDto orderToSaveDto);

    OrderDto updateOrderById(Long orderId, OrderToSaveDto order);
    OrderDto findOrderById(Long id);

    //OrderDto patchOrder(Long orderId, OrderPatchDto orderPatchDto);
    void removeOrderById(Long id);

}
