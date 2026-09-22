package com.example.demo.service;

import com.example.demo.dto.PaymentRequestDto;
import com.example.demo.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto createPayment(Long orderId, PaymentRequestDto paymentRequestDto);

    PaymentResponseDto getPayment(Long id);

    void deletePayment(Long id);
}
/*
createPayment(...) → Create a payment for an existing order.
getPayment(...) → Fetch a payment.
deletePayment(...) → Remove a payment.
*/