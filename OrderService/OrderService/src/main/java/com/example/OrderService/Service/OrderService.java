package com.example.OrderService.Service;

import com.example.OrderService.Clients.ProductFeign;
import com.example.OrderService.DTO.OrderDTO;
import com.example.OrderService.Entity.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductFeign productFeign;

    public Integer placeOrder(OrderDTO orderDTO) {
    	productFeign.reduceQuantity(orderDTO.getProductId(), orderDTO.getQuantity());
        Order order=Order.builder()
                .productId(orderDTO.getProductId())
                .price(orderDTO.getAmount())
                .orderDate(Instant.now())
                .orderStatus("Order Placed")
                .quantity(orderDTO.getQuantity())
                .build();
        orderRepository.save(order);
        return order.getOrderId();
    }
}