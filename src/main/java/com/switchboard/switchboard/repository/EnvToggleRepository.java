package com.switchboard.switchboard.repository;

import com.switchboard.switchboard.entity.EnvToggle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvToggleRepository extends JpaRepository<EnvToggle,Long> {
    Optional<EnvToggle> findByEnvironmentIdAndToggleId(Long env, Long toggleId);
}
