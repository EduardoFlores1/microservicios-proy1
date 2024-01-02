package com.edu.ms_product.controllers;

import com.edu.ms_product.assemblers.ProductModelAssembler;
import com.edu.ms_product.exceptions.ProductNotFoundException;
import com.edu.ms_product.models.dtos.CreateProductDTO;
import com.edu.ms_product.models.dtos.ProductResponse;
import com.edu.ms_product.services.IProductService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService service;
    private final ProductModelAssembler assembler;

    public ProductController(IProductService service, ProductModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<ProductResponse>> findAll() {
        List<EntityModel<ProductResponse>> products = service.findAll().stream()
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(products,
                linkTo(methodOn(ProductController.class).findAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<ProductResponse> findById(@PathVariable Long id) {
        ProductResponse response = service.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return assembler.toModel(response);
    }

    @PostMapping
    ResponseEntity<?> save(@Valid @RequestBody CreateProductDTO request) {
        EntityModel<ProductResponse> entityModel = assembler.toModel(service.create(request));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
}
