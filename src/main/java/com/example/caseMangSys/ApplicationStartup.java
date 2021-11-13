package com.example.caseMangSys;

import com.example.caseMangSys.catalog.application.CaseService;
import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase;
import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase.CreateCaseCommand;
import com.example.caseMangSys.catalog.domain.SecurityLevel;
import com.example.caseMangSys.catalog.domain.StatusCase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final CaseServiceUseCase catalog;

    public ApplicationStartup(CaseService caseService) {
        this.catalog = caseService;
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate date = LocalDate.now();

        catalog.addCase(new CreateCaseCommand("Computer accident", "Computer not working", date, SecurityLevel.LOW, StatusCase.NEW));
        catalog.addCase(new CreateCaseCommand("Service accident", "Service not working", date, SecurityLevel.MEDIUM, StatusCase.NEW));
        catalog.addCase(new CreateCaseCommand("Database accident", "Database not working", date, SecurityLevel.HIGH, StatusCase.NEW));


    }

}
