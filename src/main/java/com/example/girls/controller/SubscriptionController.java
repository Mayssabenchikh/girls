package com.example.girls.controller;

import com.example.girls.entities.Subscription;
import com.example.girls.service.ISubscriptionService;
import com.example.girls.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private ISubscriptionService subscriptionService;

    @Autowired
    private IUserService userService;

    @GetMapping
    public String listSubscriptions(Model model) {
        model.addAttribute("subscriptions", subscriptionService.findAll());
        return "subscription/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("subscription", new Subscription());
        model.addAttribute("users", userService.findAll());
        return "subscription/add";
    }

    @PostMapping("/save")
    public String saveSubscription(@ModelAttribute Subscription subscription) {
        subscriptionService.save(subscription);
        return "redirect:/subscriptions";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubscription(@PathVariable Long id) {
        subscriptionService.delete(id);
        return "redirect:/subscriptions";
    }
}

