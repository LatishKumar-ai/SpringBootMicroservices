package com.example.OrderService.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ProductService/api/product")
public interface ProductFeign {

	@PutMapping("/upd/{productId}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Integer productId, @RequestParam int quantity);
}