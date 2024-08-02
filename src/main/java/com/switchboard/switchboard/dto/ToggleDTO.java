package com.switchboard.switchboard.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

public class ToggleDTO {

    private Long id;

    private String toggleName;


    private boolean toggleStatus;

    private String toggleDescription;
}
