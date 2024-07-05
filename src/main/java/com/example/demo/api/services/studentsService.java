package com.example.demo.api.services;

import com.example.demo.api.entity.students;
import com.example.demo.api.repository.studentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentsService {
    @Autowired
    private studentsRepository studentsRepository;

    // Get all users
    public List<students> getAllUsers() {
        return studentsRepository.findAll();
    }

}
