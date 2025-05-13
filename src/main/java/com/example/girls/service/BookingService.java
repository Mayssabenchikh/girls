package com.example.girls.service;

import com.example.girls.entities.Booking;
import com.example.girls.entities.Course;
import com.example.girls.entities.User;
import com.example.girls.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> findByUser(User user) {
        return bookingRepository.findByUser(user);
    }

    @Override
    public List<Booking> findByCourse(Course course) {
        return bookingRepository.findByCourse(course);
    }

    @Override
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}
