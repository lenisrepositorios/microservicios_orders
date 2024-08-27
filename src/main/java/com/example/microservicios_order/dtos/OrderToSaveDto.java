package com.example.microservicios_order.dtos;

public record OrderToSaveDto(Long id,
                             Long user_ID,
                             Long product_ID,
                             int quantity,
                             String status) {
}
