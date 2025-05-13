package com.example.girls.repository;

import com.example.girls.entities.Booking;
import com.example.girls.entities.Course;
import com.example.girls.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByCourse(Course course);
}
