package com.switchboard.switchboard.service;

import com.switchboard.switchboard.dto.ToggleDTO;

public interface ToggleService {

    ToggleDTO createToggle(ToggleDTO toggleDTO);

    ToggleDTO getToggleById(Long id);

    ToggleDTO updateToggle(ToggleDTO toggleDTO,Long id);

    void deleteToggleById(Long id);

}
