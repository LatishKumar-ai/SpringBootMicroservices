package com.example.ProductService.Exception;

public class ProductServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public ProductServiceException(String errMsg) {
        super(errMsg);
    }
}