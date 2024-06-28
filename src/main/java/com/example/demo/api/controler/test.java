package com.example.demo.api.controler;

import com.example.demo.api.Dto.testDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class test {
    @GetMapping(value = { "/list" })
    public testDto productDto() {
        return new testDto("12312");
    }
}
