package com.example.girls.service;

import com.example.girls.entities.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    Room save(Room room);
    Optional<Room> findById(Long id);
    Optional<Room> findByName(String name);
    List<Room> findAll();
    void delete(Long id);
}
