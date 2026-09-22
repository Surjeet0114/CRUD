package com.example.demo.dto;

import com.example.demo.enums.OrderStatus;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDateTime;

public class OrderResponseDto {
    private Long id;
    //private String productName;
    //private Integer quantity;
    //private Double price;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private Long userId;

    public OrderResponseDto(){}

    public OrderResponseDto(Long id,
                            //String productName,
                            //Integer quantity,
                            //Double price ,
                            OrderStatus status ,
                            LocalDateTime orderDate ,
                            Long userId ){

        this.id = id;
        //this.productName = productName;
        //this.quantity = quantity;
        //this.price = price;
        this.status = status;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //IMP
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
//The response DTO is what you'll return back to Postman after creating or fetching an order.