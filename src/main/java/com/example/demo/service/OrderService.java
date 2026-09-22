package com.example.demo.service;

import com.example.demo.dto.OrderResponseDto;
import com.example.demo.dto.OrderRequestDto;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(Long userId, OrderRequestDto dto);

    List<OrderResponseDto> getOrdersByUser(Long userId);

    OrderResponseDto getOrderById(Long orderId);

    void addProductToOrder(Long orderId, Long productId);
}
