package com.example.caseMangSys.catalog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Case {
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    private SecurityLevel securityLevel;
    private StatusCase statusCase;

    public Case(Long id, String title, String description, LocalDate date, SecurityLevel securityLevel, StatusCase statusCase) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.securityLevel = securityLevel;
        this.statusCase = statusCase;
    }

    public Case(String title, String description, LocalDate date, SecurityLevel securityLevel, StatusCase statusCase) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.securityLevel = securityLevel;
        this.statusCase = statusCase;
    }

}
