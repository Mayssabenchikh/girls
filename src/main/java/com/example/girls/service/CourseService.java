package com.example.girls.service;

import com.example.girls.entities.Course;
import com.example.girls.entities.Room;
import com.example.girls.entities.User;
import com.example.girls.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByCoach(User coach) {
        return courseRepository.findByCoach(coach);
    }

    @Override
    public List<Course> findByRoom(Room room) {
        return courseRepository.findByRoom(room);
    }

    @Override
    public List<Course> findByDateTimeBetween(LocalDateTime start, LocalDateTime end) {
        return courseRepository.findByDateTimeBetween(start, end);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }




}
