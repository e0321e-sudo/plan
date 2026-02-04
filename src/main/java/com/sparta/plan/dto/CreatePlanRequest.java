package com.sparta.plan.dto;

import lombok.Getter;

@Getter
public class CreatePlanRequest {
    private String name;
    private String title;
    private String contents;
    private String password;
}
