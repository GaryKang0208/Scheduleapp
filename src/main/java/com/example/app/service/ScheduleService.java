package com.example.app.service;

import com.example.app.dto.*;
import com.example.app.entity.Schedule;
import com.example.app.repository.SchedulRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service // 비즈니스 로직을 담당하는 계층
@RequiredArgsConstructor

public class ScheduleService {

    private final SchedulRepository schedulRepository;



    @Transactional
    public CreateResponse create(CreateRequest createSchedule) {

        //1. 요청 Dto  값으로 엔티티 생성
        Schedule schedule = new Schedule(
                createSchedule.getTitle(),
                createSchedule.getContents(),
                createSchedule.getAuthor(),
                createSchedule.getPassword());

        Schedule savedSchedule = schedulRepository.save(schedule); // db 에 저장 saveid. 생성일이 채워진 엔티리를 반환
        return new CreateResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt());   // 응답 값 반환
    }

    @Transactional(readOnly = true)    //전제 조화
    public List<GetResponse> findAll() {
        List<GetResponse> scheduleReponselist = new ArrayList<>();
        List<Schedule> scheduleList = schedulRepository.findAll();

        for(Schedule schedule : scheduleList){
            GetResponse getResponse = new GetResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContents(),
                    schedule.getAuthor(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt());
            scheduleReponselist.add(getResponse);
        }
        return scheduleReponselist;
    }
    @Transactional(readOnly = true)  //단건 조회
    public GetResponse findOne(Long id) {

        Schedule schedule = getOrThrow(id);
        return new GetResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt());
    }

    private Schedule getOrThrow(Long id) {
        return schedulRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "방명록을 찾을 수 없어요: " + id));
    }

    @Transactional
    public UpdateResponse update(Long id, UpdateRequest updateRequest) {
        Schedule schedule = getOrThrow(id);

        // 엔티티 update 메서드로 값 변경
        // 비밀번호가 맞는지 확인후 update를 쓴다
        if (!schedule.getPassword().equals(updateRequest.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }else{   schedule.update(updateRequest.getTitle(), updateRequest.getAuthor());
            Schedule updatedSchedule = schedulRepository.save(schedule);

            return new UpdateResponse(
                    updatedSchedule.getId(),
                    updatedSchedule.getTitle(),
                    updateRequest.getAuthor(),
                    updatedSchedule.getContents(),
                    updatedSchedule.getCreatedAt(),
                    updatedSchedule.getModifiedAt());}

    }

    @Transactional
    public void delete(Long id, DeleteRequest deleteRequest) {
        Schedule schedule = getOrThrow(id);
        if (!schedule.getPassword().equals(deleteRequest.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }else{ schedulRepository.delete(schedule);}



    }
}

