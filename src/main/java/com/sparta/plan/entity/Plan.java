package com.sparta.plan.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name="plans")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private String title;
    private String contents;
    private String password;

    public Plan(String name, String title, String contents, String password){
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

    public void update(String name, String title, String contents, String password){
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }



}
