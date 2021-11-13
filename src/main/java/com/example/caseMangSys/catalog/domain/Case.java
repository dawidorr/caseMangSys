package com.example.caseMangSys.catalog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Getter
@Setter
@ToString
public class Case {
    private Long id;
    private String title;
    private String description;
    private String date;
    private String securityLevel;
    private String status;

    public Case(Long id, String title, String description, String date, String securityLevel, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.securityLevel = securityLevel;
        this.status = status;
    }

    public Case(String title, String description, String date, String securityLevel, String status) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.securityLevel = securityLevel;
        this.status = status;
    }

}
