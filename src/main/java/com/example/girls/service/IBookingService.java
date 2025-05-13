package com.example.girls.service;

import com.example.girls.entities.Booking;
import com.example.girls.entities.Course;
import com.example.girls.entities.User;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking save(Booking booking);
    Optional<Booking> findById(Long id);
    List<Booking> findByUser(User user);
    List<Booking> findByCourse(Course course);
    void delete(Long id);
}