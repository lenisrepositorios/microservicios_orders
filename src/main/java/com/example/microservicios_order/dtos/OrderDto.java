package com.example.microservicios_order.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record OrderDto(Long id,
                       Long user_ID,
                       Long product_ID,
                       int quantity,
                       String status) {
}
