package com.sparta.plan.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPlanResponse {
    private final Long id;
    private final String name;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetPlanResponse(Long id, String name, String title, String contents, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
