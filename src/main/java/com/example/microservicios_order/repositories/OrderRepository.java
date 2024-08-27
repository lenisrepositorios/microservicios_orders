package com.example.microservicios_order.repositories;

import com.example.microservicios_order.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
