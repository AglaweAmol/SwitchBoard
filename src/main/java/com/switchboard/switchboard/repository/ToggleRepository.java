package com.switchboard.switchboard.repository;

import com.switchboard.switchboard.entity.Toggle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToggleRepository extends JpaRepository<Toggle,Long> {
}
