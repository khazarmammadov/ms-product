package org.khazar.products.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.khazar.products.model.request.CreateProductRequest;
import org.khazar.products.model.request.ReduceQuantityRequest;
import org.khazar.products.model.response.ProductResponse;
import org.khazar.products.service.abstraction.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductRequest createProductRequest) {
        productService.createProduct(createProductRequest);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("/reduce-quantity")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void reduceProductQuantity(@RequestBody @Valid ReduceQuantityRequest reduceQuantityRequest) {
        productService.reduceQuantityRequest(reduceQuantityRequest);
    }
}
