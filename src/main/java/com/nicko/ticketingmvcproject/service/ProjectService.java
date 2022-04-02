package com.nicko.ticketingmvcproject.service;

import com.nicko.ticketingmvcproject.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO, String> {
    void completeProject(ProjectDTO project);
}
