package com.example.caseMangSys;

import com.example.caseMangSys.catalog.application.CaseService;
import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase;
import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase.CreateCaseCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements CommandLineRunner {

    private final CaseServiceUseCase catalog;

    public ApplicationStartup(CaseService caseService) {
        this.catalog = caseService;
    }

    @Override
    public void run(String... args) throws Exception {
        catalog.addCase(new CreateCaseCommand("Computer accident", "Computer not working", "12/11/2021", "low", "new"));
        catalog.addCase(new CreateCaseCommand("Service accident", "Service not working", "12/11/2021", "low", "new"));
        catalog.addCase(new CreateCaseCommand("Database accident", "Database not working", "12/11/2021", "low", "new"));


    }

}
