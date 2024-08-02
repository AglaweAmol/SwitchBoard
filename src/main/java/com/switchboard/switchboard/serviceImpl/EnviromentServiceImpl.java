package com.switchboard.switchboard.serviceImpl;

import com.switchboard.switchboard.dto.EnvironmentDTO;
import com.switchboard.switchboard.entity.Environment;
import com.switchboard.switchboard.exception.ResourceNotFoundException;
import com.switchboard.switchboard.repository.EnviromentRepository;
import com.switchboard.switchboard.service.EnviromentService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


@Service
public class EnviromentServiceImpl implements EnviromentService {



    private EnviromentRepository enviromentRepository;

    private ModelMapper mapper;

    public EnviromentServiceImpl(EnviromentRepository enviromentRepository, ModelMapper mapper) {
        this.enviromentRepository = enviromentRepository;
        this.mapper = mapper;
    }

    @Override
    public EnvironmentDTO createEnvironment(EnvironmentDTO environmentDTO) {

        Environment environment=mapToEntity(environmentDTO);
        Environment environment1=enviromentRepository.save(environment);
        EnvironmentDTO environmentResponse=mapToDto(environment1);
        return environmentResponse;
    }

    @Override
    public EnvironmentDTO getEnvironmentById(Long id) {

    Environment environment=enviromentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(""));
        return mapToDto(environment);
    }

    @Override
    public EnvironmentDTO updateEnvironment(EnvironmentDTO environmentDTO, Long id) {
        Environment environment=enviromentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(""));
        environment.setId(environmentDTO.getId());
        environment.setEnvName(environmentDTO.getEnvName());
        return mapToDto(environment);
    }

    @Override
    public void deleteEnvironmentById(Long id) {

        enviromentRepository.deleteById(id);

    }

    private EnvironmentDTO mapToDto(Environment environment)
    {
        EnvironmentDTO environmentDTO=mapper.map(environment,EnvironmentDTO.class);

        return environmentDTO;
    }

    private Environment mapToEntity(EnvironmentDTO environmentDTO)
    {
        Environment environment=mapper.map(environmentDTO,Environment.class);
        return environment;
    }


}
