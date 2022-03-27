package com.nicko.ticketingmvcproject.service.impl;

import com.nicko.ticketingmvcproject.dto.RoleDTO;
import com.nicko.ticketingmvcproject.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImp extends AbstractMapService<RoleDTO, Long> implements RoleService {


    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(),object);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }
}
