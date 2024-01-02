package com.edu.ms_product.assemblers;

import com.edu.ms_product.controllers.ProductController;
import com.edu.ms_product.models.dtos.ProductResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Component
public class ProductModelAssembler implements RepresentationModelAssembler<ProductResponse, EntityModel<ProductResponse>> {
    @Override
    public EntityModel<ProductResponse> toModel(ProductResponse response) {
        return EntityModel.of(response,
                linkTo(methodOn(ProductController.class).findById(response.getId())).withSelfRel(),
                linkTo(methodOn(ProductController.class).findAll()).withRel("products"));
    }
}
