package com.nicko.ticketingmvcproject.controller;

import com.nicko.ticketingmvcproject.dto.ProjectDTO;
import com.nicko.ticketingmvcproject.dto.UserDTO;
import com.nicko.ticketingmvcproject.service.ProjectService;
import com.nicko.ticketingmvcproject.service.RoleService;
import com.nicko.ticketingmvcproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    public ProjectController(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService=projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", userService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project, Model model) {
        projectService.save(project);
        return "redirect:/project/create";
    }
}
