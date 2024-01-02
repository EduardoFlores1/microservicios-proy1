package com.edu.ms_product.services;

import com.edu.ms_product.models.dtos.CreateProductDTO;
import com.edu.ms_product.models.dtos.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductResponse> findAll();
    ProductResponse create(CreateProductDTO createProductDTO);
    Optional<ProductResponse> findById(Long id);
}
