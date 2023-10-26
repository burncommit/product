package com.example.product.data.mapper;

import com.example.product.data.dto.ProductDto;
import com.example.product.data.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements EntityMapper<ProductDto, ProductEntity>{

    @Override
    public ProductEntity toEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productDto.getProductName());
        productEntity.setProductPrice(productDto.getProductPrice());
        productEntity.setCategory(productDto.getCategory());
        return productEntity;
    }


}
