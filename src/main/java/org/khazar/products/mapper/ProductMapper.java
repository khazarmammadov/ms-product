package org.khazar.products.mapper;

import org.khazar.products.dao.entity.ProductEntity;
import org.khazar.products.model.request.CreateProductRequest;
import org.khazar.products.model.response.ProductResponse;

import java.time.LocalDateTime;

public enum ProductMapper {

    PRODUCT_MAPPER;

    public ProductEntity buildProductEntity(CreateProductRequest createProductRequest) {
        return ProductEntity.builder()
                .name(createProductRequest.getName())
                .description(createProductRequest.getDescription())
                .price(createProductRequest.getPrice())
                .quantity(createProductRequest.getQuantity())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public ProductResponse buildProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .quantity(productEntity.getQuantity())
                .build();
    }
}
