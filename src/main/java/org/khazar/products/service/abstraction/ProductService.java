package org.khazar.products.service.abstraction;

import jakarta.validation.Valid;
import org.khazar.products.model.request.CreateProductRequest;
import org.khazar.products.model.request.ReduceQuantityRequest;
import org.khazar.products.model.response.ProductResponse;

import java.util.Optional;

public interface ProductService {

    void createProduct(CreateProductRequest request);

    ProductResponse findProductById(Long id);

    void reduceQuantityRequest(ReduceQuantityRequest reduceQuantityRequest);
}
