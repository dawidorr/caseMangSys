package com.example.caseMangSys;

public class Case {
    Long id;
    String title;
    String description;
    String date;
    String securityLevel;
    String status;

    public Case(Long id, String title, String description, String date, String securityLevel, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.securityLevel = securityLevel;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", securityLevel='" + securityLevel + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
