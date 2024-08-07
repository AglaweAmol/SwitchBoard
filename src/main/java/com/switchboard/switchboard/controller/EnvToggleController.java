package com.switchboard.switchboard.controller;


import com.switchboard.switchboard.entity.EnvToggle;
import com.switchboard.switchboard.service.EnvToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/env-toggle")
public class EnvToggleController {


    @Autowired
    private EnvToggleService envToggleService;

    @PostMapping("/createEnvToogle")
    public EnvToggle createEnvToggle(@RequestParam Long toggleId, @RequestParam Long environmentId, @RequestParam boolean status) {
        return envToggleService.createEnvToggle(toggleId, environmentId, status);
    }

    @PutMapping("/changeToggleStatus/{env}")
    public EnvToggle changeToggleStatus(@PathVariable Long env, @RequestParam Long toggleId, @RequestParam boolean status) {
        return envToggleService.changeToggleStatus(env, toggleId, status);
    }

    @DeleteMapping
    public void deleteEnvToggle(@RequestParam Long id) {
        envToggleService.deleteEnvToggle(id);
    }
}
