package com.example.OrderService.Controller;

import com.example.OrderService.DTO.OrderDTO;
import com.example.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Integer> placeOrder(@RequestBody OrderDTO orderDTO) {
        Integer orderId=orderService.placeOrder(orderDTO);
        return new ResponseEntity<Integer>(orderId, HttpStatus.CREATED);
    }
}