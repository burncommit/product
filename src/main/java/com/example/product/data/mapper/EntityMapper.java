package com.example.product.data.mapper;

public interface EntityMapper<DTO, Entity> {
    Entity toEntity(DTO dto);
}
