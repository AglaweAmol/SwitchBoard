package com.switchboard.switchboard.dto;

import lombok.Data;


@Data
public class ToggleDTO {

    private Long id;

    private String toggleName;


    private boolean toggleStatus;

    private String toggleDescription;
}
