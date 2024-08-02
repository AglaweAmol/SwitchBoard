package com.switchboard.switchboard.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "envtoggle")
public class EnvToggle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "toggle_id", nullable = false)
    private Toggle toggle;

    @ManyToOne
    @JoinColumn(name = "environment_id", nullable = false)
    private Environment environment;

}
