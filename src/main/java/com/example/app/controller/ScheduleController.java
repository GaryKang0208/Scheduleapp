package com.example.app.controller;


import com.example.app.dto.CreateRequest;
import com.example.app.dto.CreateResponse;
import com.example.app.service.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 데이터를 반환하는 아노테이선 (Json)
@RequiredArgsConstructor // final 필드를 받아 생성자를 만들어주는 아노테이션
@RequestMapping("/schedules")

public class ScheduleController {

    private final ScheduleService scheduleService;

    // post 요청 dto 만들어 저장후 응답을 dto로 변환

    @PostMapping
    public ResponseEntity<CreateResponse> create(@RequestBody CreateRequest createSchedule){

        CreateResponse saved = scheduleService.create(createSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }
}
