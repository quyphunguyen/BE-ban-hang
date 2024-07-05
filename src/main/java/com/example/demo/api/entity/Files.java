package com.example.demo.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "datafile")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "url")
    private String url;

}
