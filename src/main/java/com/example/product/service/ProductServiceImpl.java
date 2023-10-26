package com.example.product.service;

import com.example.product.data.dto.ProductDto;
import com.example.product.data.entity.ProductEntity;
import com.example.product.data.mapper.ProductMapper;
import com.example.product.data.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductEntity createProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toEntity(productDto);
        log.info("productDto : {}", productDto);
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public ProductEntity updateProduct(int productId, ProductDto productDto) {
        ProductEntity existProduct = productRepository.findById(productId).orElse(null);
        if(existProduct != null){
            ProductEntity updateProduct = productMapper.toEntity(productDto);
            updateProduct.setProductId(productId);
            return productRepository.save(updateProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductEntity> findByProductNameContaining(String keyword) {
        return productRepository.findByProductNameContaining(keyword);
    }

    @Override
    public List<ProductEntity> findByProductPriceLessThan(int value) {
        return productRepository.findByProductPriceLessThan(value);
    }

    @Override
    public List<ProductEntity> findByProductPriceGreaterThan(int value) {
        return productRepository.findByProductPriceGreaterThan(value);
    }

    @Override
    public List<ProductEntity> findByProductPriceBetween(int value1, int value2) {
        return productRepository.findByProductPriceBetween(value1,value2);
    }
}
