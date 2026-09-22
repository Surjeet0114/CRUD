package com.example.demo.dto;

import com.example.demo.enums.OrderStatus;
import jakarta.validation.constraints.*;

public class OrderRequestDto {

    /*
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100,
            message = "Product name must be between 2 and 100 characters")
    private String productName;


    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    private Integer quantity;


    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;
    */

    @NotNull(message = "Status is required")
    private OrderStatus status;

    public OrderRequestDto() {
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}