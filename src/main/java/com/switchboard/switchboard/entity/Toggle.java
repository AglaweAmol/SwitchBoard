package com.switchboard.switchboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@Entity
@Table(name = "toggle")
public class Toggle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "toggle_name")
    private String toggleName;


    @Column(name = "toggle_status")
    private boolean toggleStatus;

    @Column(name = "toggle_description", nullable = true)
    private String toggleDescription;
}
