package com.example.demo.api.controler;

import com.example.demo.api.Dto.ProductDto;
import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Product;
import com.example.demo.api.entity.Users;
import com.example.demo.api.services.ProductService;
import com.example.demo.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductControler {
    @Autowired
    private ProductService productService;

    @PostMapping(value = { "/product/save" })
    public Product userSave(@RequestBody ProductDto request) {
        Product product = this.productService.save(request);
        return product;
    }

    @GetMapping(value = { "/product/findAll" })
    public List<ProductDto> getAllUsers() {
        List<ProductDto> products = this.productService.findAll();
        return products;
    }


}
