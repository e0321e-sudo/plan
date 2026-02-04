package com.sparta.plan.controller;

import com.sparta.plan.dto.CreatePlanRequest;
import com.sparta.plan.dto.CreatePlanResponse;
import com.sparta.plan.dto.GetPlanResponse;
import com.sparta.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private  final PlanService planService;

    @PostMapping("/plans")
    public ResponseEntity<CreatePlanResponse> createPlan(@RequestBody CreatePlanRequest request){
       return ResponseEntity.status(HttpStatus.CREATED).body(planService.createPlan(request));
    }
    @GetMapping("/plans/{planId}")
    public ResponseEntity<GetPlanResponse> getPlan(@PathVariable Long planId){
        return ResponseEntity.status(HttpStatus.OK).body(planService.findOne(planId));
    }

}
