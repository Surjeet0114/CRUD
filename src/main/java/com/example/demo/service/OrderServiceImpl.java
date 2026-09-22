package com.example.demo.service;

import com.example.demo.dto.OrderRequestDto;
import com.example.demo.dto.OrderResponseDto;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository ,ProductRepository productRepository) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponseDto createOrder(Long userId,
                                        OrderRequestDto dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + userId));

        Order order = new Order();

        //order.setProductName(dto.getProductName());
        //order.setQuantity(dto.getQuantity());
        //order.setPrice(dto.getPrice());
        order.setStatus(dto.getStatus());

        order.setUser(user);

        Order savedOrder = orderRepository.save(order);

        return mapToResponseDto(savedOrder);
    }

    @Override
    public List<OrderResponseDto> getOrdersByUser(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + userId));

        List<Order> orders = orderRepository.findByUserId(userId);

        return orders.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id: " + orderId));

        return mapToResponseDto(order);
    }

    @Override
    public void addProductToOrder(Long orderId, Long productId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id: " + orderId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + productId));

        order.getProducts().add(product);
        /*
        if(true){
            throw new RuntimeException("Testing rollback");
        }
        */
        orderRepository.save(order);
    }

    private OrderResponseDto mapToResponseDto(Order order) {

        OrderResponseDto dto = new OrderResponseDto();

        dto.setId(order.getId());
        //dto.setProductName(order.getProductName());
        //dto.setQuantity(order.getQuantity());
        //dto.setPrice(order.getPrice());
        dto.setStatus(order.getStatus());
        dto.setOrderDate(order.getOrderDate());

        if (order.getUser() != null) {
            dto.setUserId(order.getUser().getId());
        }

        return dto;
    }

}