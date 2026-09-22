package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class ProductRequestDto {

    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 2, max = 100)
    private String name;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
