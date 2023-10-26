package com.example.product.service;

import com.example.product.data.dto.ProductDto;
import com.example.product.data.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductDto productDto);
    List<ProductEntity> getAllProduct();
    ProductEntity getProductById(int ProductId);
    ProductEntity updateProduct(int productId, ProductDto productDto);
    void deleteProduct(int productId);

    List<ProductEntity> findByProductNameContaining(String keyword);
    List<ProductEntity> findByProductPriceLessThan(int value);
    List<ProductEntity> findByProductPriceGreaterThan(int value);
    List<ProductEntity> findByProductPriceBetween(int value1, int value2);
}
