package com.example.girls.controller;

import com.example.girls.entities.Course;
import com.example.girls.repository.CourseRepository;
import com.example.girls.service.ICourseService;
import com.example.girls.service.IRoomService;
import com.example.girls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        return "course/list"; // view = templates/courses.html
    }
    @Autowired
    private ICourseService courseService;

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IUserService userService;



    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course/list"; // <== Le bon chemin vers le template
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("rooms", roomService.findAll());
        model.addAttribute("coaches", userService.findAll()); // à filtrer par rôle si besoin
        return "course/form"; // <== Le bon chemin vers le template
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/courses";
    }
}
