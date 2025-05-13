package com.example.girls.service;

import com.example.girls.entities.Role;
import com.example.girls.entities.User;
import com.example.girls.exception.ResourceNotFoundException;
import com.example.girls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    private final UserRepository userRepository;

    @Autowired
    public CoachService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Récupérer tous les coachs
     */
    public List<User> getAllCoaches() {
        return userRepository.findByRole(Role.COACH);
    }

    /**
     * Récupérer un coach par ID
     */
    public User getCoachById(Long id) {
        return userRepository.findByIdAndRole(id, Role.COACH)
                .orElseThrow(() -> new ResourceNotFoundException("Coach not found with id: " + id));
    }

    /**
     * Créer un nouveau coach
     */
    public User createCoach(User coach) {
        // S'assurer que le rôle est COACH
        coach.setRole(Role.COACH);
        return userRepository.save(coach);
    }

    /**
     * Mettre à jour un coach existant
     */
    public User updateCoach(Long id, User coachDetails) {
        User coach = getCoachById(id);

        // Mettre à jour les propriétés du coach
        coach.setUsername(coachDetails.getUsername());
        coach.setEmail(coachDetails.getEmail());
        coach.setFirstName(coachDetails.getFirstName());
        coach.setLastName(coachDetails.getLastName());
        coach.setCoachImageUrl(coachDetails.getCoachImageUrl());

        // Si le mot de passe est fourni, le mettre à jour
        if (coachDetails.getPassword() != null && !coachDetails.getPassword().isEmpty()) {
            coach.setPassword(coachDetails.getPassword());
            // Note: dans une application réelle, vous devriez encoder le mot de passe
        }

        // S'assurer que le rôle reste COACH
        coach.setRole(Role.COACH);

        return userRepository.save(coach);
    }

    /**
     * Supprimer un coach
     */
    public void deleteCoach(Long id) {
        User coach = getCoachById(id);
        userRepository.delete(coach);
    }
}