package com.nicko.ticketingmvcproject.service;

import com.nicko.ticketingmvcproject.dto.TaskDTO;
import com.nicko.ticketingmvcproject.dto.UserDTO;
import com.nicko.ticketingmvcproject.enums.Status;
import com.nicko.ticketingmvcproject.service.impl.AbstractMapService;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long>{
    List<TaskDTO> findTasksByManager(UserDTO manager);

    List<TaskDTO> findAllTasksByStatus(Status status);

    List<TaskDTO> findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO task);
}
