package com.example.girls.controller;

import com.example.girls.entities.Booking;
import com.example.girls.service.IBookingService;
import com.example.girls.service.ICourseService;
import com.example.girls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICourseService courseService;

    @GetMapping
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingService.findByUser(userService.findAll().get(0))); // exemple
        return "booking/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("courses", courseService.findAll());
        return "booking/add";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute Booking booking) {
        bookingService.save(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.delete(id);
        return "redirect:/bookings";
    }
}

