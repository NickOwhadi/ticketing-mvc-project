package com.nicko.ticketingmvcproject.service.impl;

import com.nicko.ticketingmvcproject.dto.RoleDTO;
import com.nicko.ticketingmvcproject.dto.UserDTO;
import com.nicko.ticketingmvcproject.service.RoleService;
import com.nicko.ticketingmvcproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp extends AbstractMapService<UserDTO, String> implements UserService {

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }
}
