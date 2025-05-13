package com.example.girls.service;

import com.example.girls.entities.Notification;
import com.example.girls.entities.User;

import java.util.List;
import java.util.Optional;

public interface INotificationService {
    Notification save(Notification notification);
    Optional<Notification> findById(Long id);
    List<Notification> findByUser(User user);
    void delete(Long id);
}