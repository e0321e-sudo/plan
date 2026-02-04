package com.sparta.plan.service;

import com.sparta.plan.dto.*;
import com.sparta.plan.entity.Plan;
import com.sparta.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



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
    public List<GetPlanResponse> findAll(String name) {
        List<Plan> plans;

        if(name == null || name.isBlank()){
            plans = planRepository.findAll();
        }else {
            plans = planRepository.findByName(name);
        }
        plans.sort(Comparator.comparing(Plan::getUpdatedAt).reversed());

            List<GetPlanResponse> dtos = new ArrayList<>();
            for (Plan plan : plans) {
                dtos.add(new GetPlanResponse(
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

    @Transactional
    public UpdatePlanResponse updatePlan(Long planId, UpdatePlanRequest request) {
        Plan plan = planRepository.findById(planId).orElseThrow(
            () -> new IllegalArgumentException("해당하는 일정이 없습니다.")
        );

        if(!plan.getPassword().equals(request.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다!");
        }

        plan.updatePlan(
                request.getName(),
                request.getTitle()
        );

        return new UpdatePlanResponse(
                plan.getId(),
                plan.getName(),
                plan.getTitle(),
                plan.getContents(),
                plan.getCreatedAt(),
                plan.getUpdatedAt()
        );
    }
    @Transactional
    public void delete(Long planId, DeletePlanRequest request) {
        Plan plan = planRepository.findById(planId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 일정이 없습니다.")
        );
        if(!plan.getPassword().equals(request.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다!");
        }
        planRepository.deleteById(planId);
    }
}


