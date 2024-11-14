package org.khazar.products.service.concentrate;

import lombok.RequiredArgsConstructor;
import org.khazar.products.dao.repository.ProductRepository;
import org.khazar.products.exception.InsufficientQuantityException;
import org.khazar.products.exception.NotFoundException;
import org.khazar.products.model.enums.ErrorMessage;
import org.khazar.products.model.request.CreateProductRequest;
import org.khazar.products.model.request.ReduceQuantityRequest;
import org.khazar.products.model.response.ProductResponse;
import org.khazar.products.service.abstraction.ProductService;
import org.springframework.stereotype.Service;

import static org.khazar.products.mapper.ProductMapper.PRODUCT_MAPPER;


@Service
@RequiredArgsConstructor
public class ProductServiceHandler implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(CreateProductRequest createProductRequest) {
        productRepository.save(PRODUCT_MAPPER.buildProductEntity(createProductRequest));
    }

    @Override
    public ProductResponse findProductById(Long id) {
        return productRepository.findById(id)
                .map(PRODUCT_MAPPER::buildProductResponse)
                .orElseThrow(
                        () -> new NotFoundException(String.format(ErrorMessage.PRODUCT_NOT_FOUND.getMessage(), id)));
    }

    @Override
    public void reduceQuantityRequest(ReduceQuantityRequest reduceQuantityRequest) {
        var productEntity = productRepository.findById(reduceQuantityRequest.getProductId())
                .orElseThrow(
                        () -> new NotFoundException(String.format(
                                ErrorMessage.PRODUCT_NOT_FOUND.getMessage(),
                                reduceQuantityRequest.getProductId())));

        if(productEntity.getQuantity() < reduceQuantityRequest.getQuantity()) {
            throw new InsufficientQuantityException(String.format(
                    ErrorMessage.INSUFFICIENT_QUANTITY.getMessage(),
                    productEntity.getId()));
        }

        productEntity.setQuantity(productEntity.getQuantity() - reduceQuantityRequest.getQuantity());

        productRepository.save(productEntity);
    }
}
