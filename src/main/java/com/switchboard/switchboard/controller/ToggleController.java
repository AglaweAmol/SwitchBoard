package com.switchboard.switchboard.controller;


import com.switchboard.switchboard.dto.ToggleDTO;
import com.switchboard.switchboard.entity.Toggle;
import com.switchboard.switchboard.service.ToggleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/toggle")
public class ToggleController {



    private ToggleService toggleService;

    public ToggleController(ToggleService toggleService) {
        this.toggleService = toggleService;
    }


    @PostMapping("/createtoggle")
    private ResponseEntity<ToggleDTO> createToggle(@RequestBody ToggleDTO toggleDTO)
    {
        return new ResponseEntity<>(toggleService.createToggle(toggleDTO), HttpStatus.CREATED);
    }

    @GetMapping("/toggle/{id}")
    private ResponseEntity<ToggleDTO> getToggleById(@PathVariable(name="id") long id)
    {
        return ResponseEntity.ok(toggleService.getToggleById(id));
    }



















}
