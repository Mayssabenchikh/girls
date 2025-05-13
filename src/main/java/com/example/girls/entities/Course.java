package com.example.girls.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDateTime dateTime;
    private Integer maxParticipants;
    private String image;
    @ManyToOne
    private Room room;

    @ManyToOne
    private User coach;

    @OneToMany(mappedBy = "course")
    private List<Booking> bookings;

    // Getters and Setters
}
