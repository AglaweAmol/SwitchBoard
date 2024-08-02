package com.switchboard.switchboard.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "environment")
public class Environment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "environment_name")
    private String envName;


}
