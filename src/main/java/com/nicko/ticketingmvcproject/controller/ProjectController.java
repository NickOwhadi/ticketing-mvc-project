package com.nicko.ticketingmvcproject.controller;


import com.nicko.ticketingmvcproject.dto.ProjectDTO;
import com.nicko.ticketingmvcproject.dto.UserDTO;
import com.nicko.ticketingmvcproject.service.ProjectService;
import com.nicko.ticketingmvcproject.service.RoleService;
import com.nicko.ticketingmvcproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("managers", userService.findManagers());
        model.addAttribute("projects", projectService.findAll());
        return "project/create";
    }

    @PostMapping("/create")
    public String insertProject(ProjectDTO project, Model model) {
        projectService.save(project);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode, Model model){
        projectService.deleteById(projectCode);
        return "redirect:/project/create";
    }
    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode, Model model){
        projectService.completeProject(projectService.findById(projectCode));
        return "redirect:/project/create";
    }
    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode,Model model){

        model.addAttribute("project",projectService.findById(projectCode));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("managers",userService.findManagers());


        return "/project/update";
    }

    @PostMapping("/update")
    public String updateProject(ProjectDTO project){

        projectService.update(project);

        return "redirect:/project/create";
    }
}
