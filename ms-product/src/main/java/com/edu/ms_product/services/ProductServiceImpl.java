package com.edu.ms_product.services;

import com.edu.ms_product.mappers.ProductMapper;
import com.edu.ms_product.models.dtos.CreateProductDTO;
import com.edu.ms_product.models.dtos.ProductResponse;
import com.edu.ms_product.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    private final IProductRepository repo;
    private final ProductMapper mapper;

    public ProductServiceImpl(IProductRepository repo, ProductMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        var products = repo.findAll();
        return products.stream().map(mapper::entityToResponse).toList();
    }

    @Override
    public Optional<ProductResponse> findById(Long id) {
        return repo.findById(id).map(mapper::entityToResponse);
    }

    @Override
    @Transactional
    public ProductResponse create(CreateProductDTO request) {
        var product = repo.save(mapper.createToEntity(request));
        return mapper.entityToResponse(product);
    }

}
