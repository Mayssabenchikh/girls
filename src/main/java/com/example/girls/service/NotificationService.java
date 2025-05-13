package com.example.girls.service;

import com.example.girls.entities.Notification;
import com.example.girls.entities.User;
import com.example.girls.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> findByUser(User user) {
        return notificationRepository.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);
    }
}