package com.edu.ms_product.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long id) {
        super("Product not found, id: " + id);
    }
}
