package com.example.demo.dto;

import com.example.demo.enums.PaymentMethod;

import java.time.LocalDateTime;

public class PaymentResponseDto {

    private Long id;
    private Double amount;
    private PaymentMethod paymentMethod;
    private LocalDateTime paymentDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}

/*
Receive payment data from Postman (PaymentRequestDto)
Send payment data back in responses (PaymentResponseDto)
*/
