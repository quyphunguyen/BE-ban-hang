package com.example.demo.api.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class test {
    @GetMapping(value = { "/list" })
    public String productDto() {

        return "1231";
    }
}
