package com.switchboard.switchboard.service;

import com.switchboard.switchboard.dto.EnvironmentDTO;
import com.switchboard.switchboard.dto.ToggleDTO;

public interface EnviromentService {

    EnvironmentDTO createEnvironment(EnvironmentDTO EnvironmentDTO);

    EnvironmentDTO getEnvironmentById(Long id);

    EnvironmentDTO updateEnvironment(EnvironmentDTO EnvironmentDTO,Long id);

    void deleteEnvironmentById(Long id);

}
