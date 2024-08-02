package com.switchboard.switchboard.serviceImpl;

import com.switchboard.switchboard.dto.EnvironmentDTO;
import com.switchboard.switchboard.dto.ToggleDTO;
import com.switchboard.switchboard.entity.Environment;
import com.switchboard.switchboard.entity.Toggle;
import com.switchboard.switchboard.exception.ResourceNotFoundException;
import com.switchboard.switchboard.repository.ToggleRepository;
import com.switchboard.switchboard.service.ToggleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ToggleServiceImpl implements ToggleService {


    private ToggleRepository toggleRepository;

    private ModelMapper mapper;

    public ToggleServiceImpl(ToggleRepository toggleRepository, ModelMapper mapper) {
        this.toggleRepository = toggleRepository;
        this.mapper = mapper;
    }

    @Override
    public ToggleDTO createToggle(ToggleDTO toggleDTO) {

        Toggle toggle=mapToEntity(toggleDTO);
        Toggle toggle1=toggleRepository.save(toggle);
        ToggleDTO toggleDTO1=mapToDto(toggle1);
        return toggleDTO1;
    }

    @Override
    public ToggleDTO getToggleById(Long id) {
        Toggle toggle = toggleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(""));

        return mapToDto(toggle);
    }

    @Override
    public ToggleDTO updateToggle(ToggleDTO toggleDTO, Long id) {
        Toggle toggle = toggleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(""));
        toggle.setToggleName(toggleDTO.getToggleName());
        toggle.setToggleDescription(toggleDTO.getToggleDescription());
        toggle.setToggleStatus(toggleDTO.isToggleStatus());
        Toggle toggle1=toggleRepository.save(toggle);
        return mapToDto(toggle1);
    }

    @Override
    public void deleteToggleById(Long id) {

        toggleRepository.deleteById(id);

    }

    private ToggleDTO mapToDto(Toggle toggle)
    {
        ToggleDTO toggleDTO=mapper.map(toggle,ToggleDTO.class);

        return toggleDTO;
    }

    private Toggle mapToEntity(ToggleDTO toggleDTO)
    {
        Toggle toggle=mapper.map(toggleDTO,Toggle.class);
        return toggle;
    }

}
