package com.sparta.plan.service;

import com.sparta.plan.dto.CreatePlanRequest;
import com.sparta.plan.dto.CreatePlanResponse;
import com.sparta.plan.entity.Plan;
import com.sparta.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    @Transactional
    public CreatePlanResponse CreatePlan(CreatePlanRequest request){
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
}
