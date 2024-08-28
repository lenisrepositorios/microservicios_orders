package com.example.microservicios_order.controllers;

import com.example.microservicios_order.dtos.OrderDto;
import com.example.microservicios_order.dtos.OrderToSaveDto;
import com.example.microservicios_order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderToSaveDto orderToSaveDto) {
        OrderDto savedOrder = orderService.saveOrder(orderToSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto order = orderService.findOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrderById(@PathVariable Long id, @RequestBody OrderToSaveDto orderToSaveDto) {
        OrderDto updatedOrder = orderService.updateOrderById(id, orderToSaveDto);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long id) {
        orderService.removeOrderById(id);
        return ResponseEntity.noContent().build();
    }
}
