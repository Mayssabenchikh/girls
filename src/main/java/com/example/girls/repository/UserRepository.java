package com.example.girls.repository;

import com.example.girls.entities.Role;
import com.example.girls.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);

    // Ajouter cette méthode pour trouver un coach par ID
    Optional<User> findByIdAndRole(Long id, Role role);}