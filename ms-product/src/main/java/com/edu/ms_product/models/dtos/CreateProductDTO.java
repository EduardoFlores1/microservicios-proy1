package com.edu.ms_product.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDTO {
    @NotEmpty
    @Size(min = 8, max = 8)
    private String sku;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;
    @NotEmpty
    @Size(min = 3, max = 255)
    private String description;
    @NotNull
    @Positive
    private Double price;
    @NotNull
    private Boolean status;
}
