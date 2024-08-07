package com.switchboard.switchboard.entity;


import lombok.Data;

import javax.persistence.*;


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
