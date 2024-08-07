package com.switchboard.switchboard.dto;


import lombok.Data;


@Data
public class EnvToggleDTO {

    private Long id;
    private boolean status;
    private Long toggleId;
    private Long environmentId;
}
