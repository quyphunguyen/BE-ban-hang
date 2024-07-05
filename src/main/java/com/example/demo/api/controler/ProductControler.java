package com.example.demo.api.controler;

import com.example.demo.api.Dto.ProductDto;
import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Product;
import com.example.demo.api.entity.Users;
import com.example.demo.api.services.ProductService;
import com.example.demo.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api")
public class ProductControler {
    @Autowired
    private ProductService productService;

    @PostMapping(value = { "/product/save" })
    public Product save(@RequestBody ProductDto request) {
        Product product = this.productService.save(request);
        return product;
    }

    @PostMapping(value = { "/product/delete" })
    public boolean delete(@RequestParam("id") String id) throws IOException {
        boolean result = this.productService.delete(id);
        return result;
    }

    @GetMapping(value = { "/product/findAll" })
    public List<ProductDto> findAll() {
        List<ProductDto> products = this.productService.findAll();
        return products;
    }


}
