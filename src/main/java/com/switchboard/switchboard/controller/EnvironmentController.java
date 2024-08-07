package com.switchboard.switchboard.controller;


import com.switchboard.switchboard.dto.EnvironmentDTO;
import com.switchboard.switchboard.service.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/environments")
public class EnvironmentController {

    private final EnviromentService environmentService;

    @Autowired
    public EnvironmentController(EnviromentService environmentService) {
        this.environmentService = environmentService;
    }

    @PostMapping
    public ResponseEntity<EnvironmentDTO> createEnvironment(@RequestBody EnvironmentDTO environmentDTO) {
        EnvironmentDTO createdEnvironment = environmentService.createEnvironment(environmentDTO);
        return ResponseEntity.ok(createdEnvironment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvironmentDTO> getEnvironmentById(@PathVariable Long id) {
        EnvironmentDTO environment = environmentService.getEnvironmentById(id);
        return ResponseEntity.ok(environment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvironmentDTO> updateEnvironment(@PathVariable Long id, @RequestBody EnvironmentDTO environmentDTO) {
        EnvironmentDTO updatedEnvironment = environmentService.updateEnvironment(environmentDTO, id);
        return ResponseEntity.ok(updatedEnvironment);
    }



}

