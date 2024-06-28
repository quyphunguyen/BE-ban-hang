package com.example.demo.api.mapper;

import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    private static ModelMapper mapper = new ModelMapper();

    public UserDto userToDto(Users users) {
        // Map thành DTO
        UserDto userDto = mapper.map(users, UserDto.class);

        return userDto;
    }

    public static Users dtoToUser(UserDto userDto) {
        // Map thành DTO
        Users user = mapper.map(userDto, Users.class);

        return user;
    }
}
