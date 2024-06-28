package com.example.demo.api.repository;

import com.example.demo.api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
     Users findFirstByUserNameAndUserPassword(String userName, String password);
}

