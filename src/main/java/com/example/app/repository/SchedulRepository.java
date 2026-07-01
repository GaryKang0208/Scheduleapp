package com.example.app.repository;

import com.example.app.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByAuthorOrderByModifiedAt(String author);
}
