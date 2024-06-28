package com.example.demo.api.controler;

import com.example.demo.api.entity.students;
import com.example.demo.api.services.studentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class test {
    @Autowired
    private studentsService studentsService;

    @GetMapping(value = { "/list" })
    public List<students> productDto() {
        List<students> students = studentsService.getAllUsers();
        return students;
    }
}
