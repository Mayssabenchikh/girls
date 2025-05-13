package com.example.girls.controller;

import com.example.girls.entities.Notification;
import com.example.girls.service.INotificationService;
import com.example.girls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @Autowired
    private IUserService userService;

    @GetMapping
    public String listNotifications(Model model) {
        model.addAttribute("notifications", notificationService.findByUser(userService.findAll().get(0))); // à adapter
        return "notification/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("notification", new Notification());
        model.addAttribute("users", userService.findAll());
        return "notification/add";
    }

    @PostMapping("/save")
    public String saveNotification(@ModelAttribute Notification notification) {
        notificationService.save(notification);
        return "redirect:/notifications";
    }

    @GetMapping("/delete/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.delete(id);
        return "redirect:/notifications";
    }
}
