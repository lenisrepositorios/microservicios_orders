package com.example.microservicios_order.services;

import com.example.microservicios_order.dtos.OrderDto;
import com.example.microservicios_order.dtos.OrderMapper;
import com.example.microservicios_order.dtos.OrderToSaveDto;
import com.example.microservicios_order.models.Order;
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
        Order order = orderMapper.saveDtoToEntity(orderToSaveDto);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public OrderDto findOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDto updateOrderById(Long id, OrderToSaveDto orderToSaveDto) {
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setQuantity(orderToSaveDto.quantity());

            Order savedOrder = orderRepository.save(existingOrder);
            return orderMapper.toDto(savedOrder);
        }).orElseThrow();
    }

    @Override
    public void removeOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow();
        orderRepository.delete(order);
    }
}
