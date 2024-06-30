package com.example.demo.api.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String id;
    private String imgSrc;

    private String title;

    private String price;

    private String rprice;
}
