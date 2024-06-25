package com.example.ProductService.Service;

import com.example.ProductService.DTO.ProductDTO;
import com.example.ProductService.Entity.Product;
import com.example.ProductService.Exception.ProductServiceException;
import com.example.ProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Integer addProduct(ProductDTO productDTO) throws ProductServiceException {
        Product product=Product.builder()
                .productName(productDTO.getProductName())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .build();
        productRepository.save(product);
        return product.getProductId();
    }

    public ProductDTO getProductById(Integer productId) throws ProductServiceException {
        Product product=productRepository.findById(productId).get();
        ProductDTO productDTO=ProductDTO.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
        return productDTO;
    }

    public void reduceQuantity(Integer productId, int quantity) throws ProductServiceException {
        Product product=productRepository.findById(productId).orElseThrow(() -> new ProductServiceException("Product Not Found"));
        if (product instanceof Product)
            if (product.getQuantity() < quantity)
                throw new ProductServiceException("Not In Stock");
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }
}