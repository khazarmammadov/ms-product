package org.khazar.products.dao.repository;

import org.khazar.products.dao.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {


}
