package com.example.product.data.repository;

import com.example.product.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByProductNameContaining(String keyword);
    List<ProductEntity> findByProductPriceLessThan(int value);
    List<ProductEntity> findByProductPriceGreaterThan(int value);
    List<ProductEntity> findByProductPriceBetween(int value1, int value2);

}
