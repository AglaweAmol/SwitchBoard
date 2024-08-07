package com.switchboard.switchboard.serviceImpl;

import com.switchboard.switchboard.dto.EnvToggleDTO;
import com.switchboard.switchboard.entity.EnvToggle;
import com.switchboard.switchboard.entity.Environment;
import com.switchboard.switchboard.entity.Toggle;
import com.switchboard.switchboard.repository.EnvToggleRepository;
import com.switchboard.switchboard.repository.EnviromentRepository;
import com.switchboard.switchboard.repository.ToggleRepository;
import com.switchboard.switchboard.service.EnvToggleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EnvToggleServiceImpl implements EnvToggleService {



    @Autowired
    private EnvToggleRepository envToggleRepository;

    @Autowired
    private ToggleRepository toggleRepository;

    @Autowired
    private EnviromentRepository environmentRepository;
    private ModelMapper mapper;

    @Override
    public EnvToggle createEnvToggle(Long toggleId, Long environmentId, boolean status) {
        Optional<Toggle> toggle = toggleRepository.findById(toggleId);
        Optional<Environment> environment = environmentRepository.findById(environmentId);

        if (toggle.isPresent() && environment.isPresent()) {
            EnvToggle envToggle = new EnvToggle();
            envToggle.setToggle(toggle.get());
            envToggle.setEnvironment(environment.get());
            envToggle.setStatus(status);

            return envToggleRepository.save(envToggle);
        } else {
            throw new RuntimeException("Toggle or Environment not found");
        }
    }

    @Override
    public EnvToggle changeToggleStatus(Long env, Long toggleId, boolean status) {
        Optional<EnvToggle> envToggleOptional = envToggleRepository.findByEnvironmentIdAndToggleId(env, toggleId);

        if (envToggleOptional.isPresent()) {
            EnvToggle envToggle = envToggleOptional.get();
            envToggle.setStatus(status);
            return envToggleRepository.save(envToggle);
        } else {
            throw new RuntimeException("EnvToggle not found");
        }
    }

    @Override
    public void deleteEnvToggle(Long id) {
        envToggleRepository.deleteById(id);
    }


    private EnvToggleDTO mapToDto(EnvToggle envToggle)
    {
        EnvToggleDTO envToggleDTO=mapper.map(envToggle,EnvToggleDTO.class);
        return envToggleDTO;
    }

    private EnvToggle mapToEntity(EnvToggleDTO envToggleDTO)
    {
       EnvToggle envToggle=mapper.map(envToggleDTO,EnvToggle.class);
       return envToggle;
    }


}
