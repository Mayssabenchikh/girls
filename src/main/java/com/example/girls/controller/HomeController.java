package com.example.girls.controller;

import com.example.girls.entities.Course;
import com.example.girls.entities.User;
import com.example.girls.repository.CourseRepository;
import com.example.girls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger; // Add this

@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class.getName()); // Add this
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public HomeController(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        // Add logged-in user information if available
        if (principal != null) {
            String email = principal.getName();
            Optional<User> userOptional = userRepository.findByEmail(email);

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                model.addAttribute("user", user);
            }
        }

        // Add courses to display on home page
        List<Course> courses = courseRepository.findAll();

        // Debug: Log how many courses are being retrieved
        LOGGER.info("Retrieved " + courses.size() + " courses from database");

        model.addAttribute("courses", courses);

        return "home";
    }
}