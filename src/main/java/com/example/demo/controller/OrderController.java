package com.example.demo.controller;

import com.example.demo.dto.OrderRequestDto;
import com.example.demo.dto.OrderResponseDto;
import com.example.demo.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    //Dependency Injection :  CONSTRUCTOR injection

    @PostMapping("/user/{userId}")
    public OrderResponseDto createOrder(
            @PathVariable Long userId,
            @Valid @RequestBody OrderRequestDto dto) {
        return orderService.createOrder(userId, dto);
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponseDto> getOrdersByUser(
            @PathVariable Long userId) {

        return orderService.getOrdersByUser(userId);
    }

    @GetMapping("/{orderId}")
    public OrderResponseDto getOrderById(
            @PathVariable Long orderId) {

        return orderService.getOrderById(orderId);
    }

    @PostMapping("/{orderId}/products/{productId}")
    public void addProductToOrder(@PathVariable Long orderId,
                                  @PathVariable Long productId) {

        orderService.addProductToOrder(orderId, productId);
    }
}