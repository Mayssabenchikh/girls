package com.example.girls.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // L'utilisateur qui reçoit la notification

    private String message; // Message de la notification
    private LocalDateTime sentDate; // Date d'envoi de la notification

    // Getters and Setters
}

