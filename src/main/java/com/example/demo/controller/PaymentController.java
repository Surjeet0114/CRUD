package com.example.demo.controller;

import com.example.demo.dto.PaymentRequestDto;
import com.example.demo.dto.PaymentResponseDto;
import com.example.demo.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/orders/{orderId}")
    public PaymentResponseDto createPayment(
            @PathVariable Long orderId,
            @Valid @RequestBody PaymentRequestDto requestDto) {

        return paymentService.createPayment(orderId, requestDto);
    }

    @GetMapping("/{id}")
    public PaymentResponseDto getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }
}
