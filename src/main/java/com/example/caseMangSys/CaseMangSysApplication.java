package com.example.caseMangSys;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CaseMangSysApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CaseMangSysApplication.class, args);
    }

    private final CaseService caseService;

    public CaseMangSysApplication(CaseService caseService) {
        this.caseService = caseService;
    }

    @Override
    public void run(String... args) throws Exception {
        CaseService service = new CaseService();
        List<Case> cases = service.findByTitle("Computer accident");
        cases.forEach(System.out::println);

    }
}
