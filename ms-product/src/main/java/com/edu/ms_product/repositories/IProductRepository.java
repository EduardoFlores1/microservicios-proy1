package com.edu.ms_product.repositories;

import com.edu.ms_product.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
