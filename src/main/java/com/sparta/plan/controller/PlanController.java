package com.sparta.plan.controller;

import com.sparta.plan.dto.CreatePlanRequest;
import com.sparta.plan.dto.CreatePlanResponse;
import com.sparta.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private  final PlanService planService;

    @PostMapping("/plans")
    public ResponseEntity<CreatePlanResponse> CreatePlan(@RequestBody CreatePlanRequest request){
       return ResponseEntity.status(HttpStatus.CREATED).body(planService.CreatePlan(request));
    }

}
