package com.example.app.repository;

import com.example.app.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulRepository extends JpaRepository<Schedule, Long> {
}
