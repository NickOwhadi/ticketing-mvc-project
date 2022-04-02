package com.nicko.ticketingmvcproject.controller;

import com.nicko.ticketingmvcproject.service.ProjectService;
import com.nicko.ticketingmvcproject.service.TaskService;
import com.nicko.ticketingmvcproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    TaskService taskService;
    UserService userService;
    ProjectService projectService;

    public TaskController(TaskService taskService, UserService userService, ProjectService projectService) {
        this.taskService = taskService;
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createTask(Model model){

        return "task/create";
    }


}
