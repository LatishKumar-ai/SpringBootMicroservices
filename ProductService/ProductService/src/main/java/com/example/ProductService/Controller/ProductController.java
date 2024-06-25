package com.example.ProductService.Controller;

import com.example.ProductService.DTO.ProductDTO;
import com.example.ProductService.Exception.ProductServiceException;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductDTO productDTO) throws ProductServiceException {
        Integer productId=productService.addProduct(productDTO);
        return new ResponseEntity<Integer>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer productId) throws ProductServiceException {
        ProductDTO productDTO1=productService.getProductById(productId);
        return new ResponseEntity<ProductDTO>(productDTO1, HttpStatus.OK);
    }

    @PutMapping("/upd/{productId}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Integer productId, @RequestParam int quantity) throws ProductServiceException {
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}