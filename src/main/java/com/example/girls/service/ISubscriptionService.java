package com.example.girls.service;

import com.example.girls.entities.Subscription;
import com.example.girls.entities.User;

import java.util.List;
import java.util.Optional;

public interface ISubscriptionService {
    Subscription save(Subscription subscription);
    Optional<Subscription> findById(Long id);
    List<Subscription> findByUser(User user);
    List<Subscription> findAll();
    void delete(Long id);
}