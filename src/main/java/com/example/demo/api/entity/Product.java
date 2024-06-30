package com.example.demo.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "imgsrc")
    private String imgSrc;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @Column(name = "rprice")
    private String rprice;
}
