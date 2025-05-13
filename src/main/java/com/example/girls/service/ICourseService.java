package com.example.girls.service;

import com.example.girls.entities.Course;
import com.example.girls.entities.Room;
import com.example.girls.entities.User;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICourseService {
    Course save(Course course);
    Optional<Course> findById(Long id);
    List<Course> findAll();
    Page<Course> findPaginated(int pageNo, int pageSize);
    List<Course> findByCoach(User coach);
    List<Course> findByRoom(Room room);
    List<Course> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);
    void delete(Long id);
}
