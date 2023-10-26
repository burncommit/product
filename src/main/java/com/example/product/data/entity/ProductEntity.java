package com.example.product.data.entity;

import com.example.product.data.dto.ProductDto;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Component
@Table(name = "PRODUCT")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private int productPrice;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "category")
    private Category category;

    public ProductDto toDto(){
        return ProductDto.builder()
                .productName(productName)
                .productPrice(productPrice)
                .category(category)
                .build();

    }
}
