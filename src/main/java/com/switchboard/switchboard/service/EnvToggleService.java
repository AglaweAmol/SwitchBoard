package com.switchboard.switchboard.service;

import com.switchboard.switchboard.entity.EnvToggle;

public interface EnvToggleService {

    EnvToggle createEnvToggle(Long toggleId, Long environmentId, boolean status);

    EnvToggle changeToggleStatus(Long env, Long toggleId, boolean status);

    void deleteEnvToggle(Long id);

}
