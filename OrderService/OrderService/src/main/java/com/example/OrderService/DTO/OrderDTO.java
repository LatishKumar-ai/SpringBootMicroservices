package com.example.OrderService.DTO;

import com.example.OrderService.Entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Integer productId;
    private int quantity;
    private double amount;
    private Payment payment;
}