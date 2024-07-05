package com.example.demo.api.services;

import com.example.demo.api.Dto.ProductDto;
import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Files;
import com.example.demo.api.entity.Product;
import com.example.demo.api.entity.Users;
import com.example.demo.api.mapper.ProductMapper;
import com.example.demo.api.mapper.UserMapper;
import com.example.demo.api.repository.ProductRepository;
import com.example.demo.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FileService fileService;

    public Product save(ProductDto productDto) {
        Product product = this.productRepository.save(ProductMapper.dtoToEntity(productDto));
        return product;

    }

    public boolean delete(String id) throws IOException {
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isPresent()){
            this.fileService.deleteFile(product.get().getFileName());
            this.productRepository.delete(product.get());
            return true;
        }
        return false;

    }

    public List<ProductDto> findAll() {
        List<ProductDto> dtos = this.productRepository.findAll().stream().map(ProductMapper::ToDto).collect(Collectors.toList());
        return dtos;

    }


}
