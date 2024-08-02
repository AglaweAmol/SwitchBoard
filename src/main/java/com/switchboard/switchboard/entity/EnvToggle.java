package com.switchboard.switchboard.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
@Entity
@Table(name = "envtoggle")
public class EnvToggle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "toggle_id", nullable = false)
    private Toggle toggle;

    @ManyToOne
    @JoinColumn(name = "environment_id", nullable = false)
    private Environment environment;

    @Column(nullable = false)
    private boolean status;
}
