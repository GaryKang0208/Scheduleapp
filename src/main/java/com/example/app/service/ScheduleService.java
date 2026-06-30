package com.example.app.service;

import com.example.app.dto.CreateRequest;
import com.example.app.dto.CreateResponse;
import com.example.app.entity.Schedule;
import com.example.app.repository.SchedulRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 비즈니스 로직을 담당하는 계층
@RequiredArgsConstructor

public class ScheduleService {

    private final SchedulRepository schedulRepository;



    @Transactional
    public CreateResponse create(CreateRequest createSchedule) {

        //1. 요청 Dto  값으로 엔티티 생성
        Schedule schedule = new Schedule(createSchedule.getTitle(), createSchedule.getContents(), createSchedule.getAuthor(), createSchedule.getPassword());

        Schedule savedSchedule = schedulRepository.save(schedule);
        return new CreateResponse(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents(), savedSchedule.getAuthor(), savedSchedule.getCreatedAt(),savedSchedule.getModifiedAt());
    }




}

