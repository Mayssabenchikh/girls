package com.example.girls.service;

import com.example.girls.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    void delete(Long id);
}
