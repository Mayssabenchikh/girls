package com.example.girls.controller;

import com.example.girls.entities.User;
import com.example.girls.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/coachs")
public class CoachController {

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    /**
     * Afficher la liste des coachs
     */
    @GetMapping
    public String listCoaches(Model model) {
        model.addAttribute("coaches", coachService.getAllCoaches());
        return "coachs/list";         // src/main/resources/templates/coachs/list.html
    }

    /**
     * Afficher le formulaire de création
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("coach", new User());
        return "coachs/form";         // src/main/resources/templates/coachs/form.html
    }

    /**
     * Enregistrer un nouveau coach
     */
    @PostMapping
    public String saveCoach(@ModelAttribute("coach") User coach) {
        coachService.createCoach(coach);
        return "redirect:/coachs";
    }

    /**
     * Afficher le formulaire d’édition
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User coach = coachService.getCoachById(id);
        model.addAttribute("coach", coach);
        return "coachs/form";
    }

    /**
     * Mettre à jour un coach existant
     */
    @PostMapping("/{id}")
    public String updateCoach(
            @PathVariable Long id,
            @ModelAttribute("coach") User coachDetails) {
        coachService.updateCoach(id, coachDetails);
        return "redirect:/coachs";
    }

    /**
     * Supprimer un coach
     */
    @GetMapping("/delete/{id}")
    public String deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return "redirect:/coachs";
    }
}
