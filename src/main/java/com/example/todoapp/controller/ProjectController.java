package com.example.todoapp.controller;

import com.example.todoapp.logic.ProjectWriteModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @GetMapping
    String showProjects(Model model){
        var projectToEdit = new ProjectWriteModel();
        projectToEdit.setDescription("chuj");
        model.addAttribute("project", projectToEdit);
        return "projects";
    }
}
