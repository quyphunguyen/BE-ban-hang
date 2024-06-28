package com.example.demo.api.repository;

import com.example.demo.api.entity.students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentsRepository extends JpaRepository<students, String> { }

