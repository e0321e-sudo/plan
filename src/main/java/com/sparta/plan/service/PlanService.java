package com.sparta.plan.service;

import com.sparta.plan.dto.CreatePlanRequest;
import com.sparta.plan.dto.CreatePlanResponse;
import com.sparta.plan.dto.GetPlanResponse;
import com.sparta.plan.entity.Plan;
import com.sparta.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    @Transactional
    public CreatePlanResponse createPlan(CreatePlanRequest request){
        Plan plan = new Plan(
                request.getName(),
                request.getTitle(),
                request.getContents(),
                request.getPassword()
        );
        Plan savedPlan = planRepository.save(plan);
        return new CreatePlanResponse(
                savedPlan.getId(),
                savedPlan.getName(),
                savedPlan.getTitle(),
                savedPlan.getContents(),
                savedPlan.getCreatedAt(),
                savedPlan.getUpdatedAt()
        );
    }
    @Transactional(readOnly = true)
    public GetPlanResponse findOne(Long planId) {
        Plan plan = planRepository.findById(planId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 일정이 없습니다.")
        );
      return new GetPlanResponse(
              plan.getId(),
              plan.getName(),
              plan.getTitle(),
              plan.getContents(),
              plan.getCreatedAt(),
              plan.getUpdatedAt()
      );
    }
    @Transactional(readOnly = true)
    public List<GetPlanResponse> findAll() {
        List<Plan> plans = planRepository.findAll();
        {

            List<GetPlanResponse> dtos = new ArrayList<>();
            for (Plan plan : plans) {
                dtos.add(
                        new GetPlanResponse(
                                plan.getId(),
                                plan.getName(),
                                plan.getTitle(),
                                plan.getContents(),
                                plan.getCreatedAt(),
                                plan.getUpdatedAt()
                        )
                );
            }
            return dtos;
        }
    }
}

