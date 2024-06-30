package com.example.demo.api.services;

import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Users;
import com.example.demo.api.mapper.UserMapper;
import com.example.demo.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    // Get all users
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users save(UserDto userDto) {

        Users  users = this.usersRepository.save(UserMapper.dtoToUser(userDto));
        return users;

    }

    public Users findFirstByUserNameAndUserPassword(UserDto userDto) {
        Users  users = this.usersRepository.findFirstByUserNameAndUserPassword(userDto.getUserName(),userDto.getUserPassword());
        return users;

    }


}
