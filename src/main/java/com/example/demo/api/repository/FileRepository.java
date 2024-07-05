package com.example.demo.api.repository;

import com.example.demo.api.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<Files, String> {
    Optional<Files> findFirstByFileName(String fileName);
}

