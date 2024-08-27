package com.example.microservicios_order;

import org.springframework.boot.SpringApplication;

public class TestMicroserviciosOrderApplication {

    public static void main(String[] args) {
        SpringApplication.from(MicroserviciosOrderApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
