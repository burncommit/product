package com.example.product.data.dto;

import com.example.product.data.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private String productName;
    private int productPrice;
    private Category category;
}
