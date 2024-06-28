package com.example.demo.api.controler;

import com.example.demo.api.Dto.UserDto;
import com.example.demo.api.entity.Users;
import com.example.demo.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserControler {
    @Autowired
    private UsersService usersService;

    @PostMapping(value = { "/user/save" })
    public Users userSave(@RequestBody Users request) {
        Users user = this.usersService.save(request);
        return user;
    }

    @GetMapping(value = { "/user/getAllUsers" })
    public List<Users> getAllUsers() {
        List<Users> users = this.usersService.getAllUsers();
        return users;
    }

    @PostMapping(value = { "/user/getById" })
    public Users findFirstByUserNameAndUserPassword(@RequestBody UserDto request) {
        Users users = this.usersService.findFirstByUserNameAndUserPassword(request);
        return users;
    }
}
