package com.example.microservicios_order.services;

import com.example.microservicios_order.dtos.OrderDto;
import com.example.microservicios_order.dtos.OrderMapper;
import com.example.microservicios_order.dtos.OrderToSaveDto;
import com.example.microservicios_order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }
    
    @Override
    public OrderDto saveOrder(OrderToSaveDto orderToSaveDto) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrder() {
        return List.of();
    }
}
