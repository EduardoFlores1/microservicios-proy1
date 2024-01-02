package com.edu.ms_product.mappers;

import com.edu.ms_product.models.dtos.CreateProductDTO;
import com.edu.ms_product.models.dtos.ProductResponse;
import com.edu.ms_product.models.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper{
    public ProductResponse entityToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }

    public Product createToEntity(CreateProductDTO create) {
        return Product.builder()
                .sku(create.getSku())
                .name(create.getName())
                .description(create.getDescription())
                .price(create.getPrice())
                .status(create.getStatus())
                .build();
    }
}
