package com.switchboard.switchboard.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class EnvironmentDTO {


    private Long id;

    private String envName;
}
