package com.nicko.ticketingmvcproject.controller;

import com.nicko.ticketingmvcproject.bootstrap.DataGenerator;
import com.nicko.ticketingmvcproject.dto.UserDTO;
import com.nicko.ticketingmvcproject.service.RoleService;
import com.nicko.ticketingmvcproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
    model.addAttribute("user",new UserDTO());
    model.addAttribute("roles",roleService.findAll() );
    model.addAttribute("users",userService.findAll());
        return "user/create";
    }
}
