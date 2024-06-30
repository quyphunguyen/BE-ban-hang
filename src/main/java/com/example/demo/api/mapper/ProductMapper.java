package com.example.demo.api.mapper;

import com.example.demo.api.Dto.ProductDto;
import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Product;
import com.example.demo.api.entity.Users;
import org.modelmapper.ModelMapper;

public class ProductMapper {
    private static ModelMapper mapper = new ModelMapper();

    public static ProductDto ToDto(Product product) {
        // Map thành DTO
        ProductDto dto = mapper.map(product, ProductDto.class);

        return dto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        // Map thành DTO
        Product entity = mapper.map(productDto, Product.class);

        return entity;
    }
}
