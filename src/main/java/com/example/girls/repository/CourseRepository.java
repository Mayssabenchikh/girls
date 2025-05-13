package com.example.girls.repository;

import com.example.girls.entities.Course;
import com.example.girls.entities.Room;
import com.example.girls.entities.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, PagingAndSortingRepository<Course, Long> {
    List<Course> findByRoom(Room room);
    List<Course> findByCoach(User coach);
    List<Course> findByDateTimeBetween(LocalDateTime start, LocalDateTime end);

    // Ajouter cette méthode pour la pagination
    Page<Course> findAll(Pageable pageable);
}
