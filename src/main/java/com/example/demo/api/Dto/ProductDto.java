package com.example.demo.api.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductDto {
    private String id;
    private String imgSrc;

    private String fileName;

    private String title;

    private String price;

    private String rprice;

    private MultipartFile multipartFile;
}
