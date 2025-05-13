package com.example.girls.service;

import com.example.girls.entities.Subscription;
import com.example.girls.entities.User;
import com.example.girls.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public List<Subscription> findByUser(User user) {
        return subscriptionRepository.findByUser(user);
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
