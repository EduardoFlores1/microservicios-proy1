package com.edu.ms_product.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProductDTO {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Boolean status;
}
