package com.example.demo.api.repository;

import com.example.demo.api.entity.Product;
import com.example.demo.api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}

