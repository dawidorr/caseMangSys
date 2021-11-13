package com.example.caseMangSys.catalog.web;

import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase;
import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase.CreateCaseCommand;
import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase.UpdateCaseCommand;
import com.example.caseMangSys.catalog.domain.Case;
import com.example.caseMangSys.catalog.domain.SecurityLevel;
import com.example.caseMangSys.catalog.domain.StatusCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/case")
@RestController
@AllArgsConstructor
public class CaseController {
    private final CaseServiceUseCase catalog;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Case> getAll() {
        return catalog.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCase(@RequestBody RestCaseCommand command) {
        catalog.addCase(command.toCreateCommand());

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Long id) {
        catalog.removeById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCase(@PathVariable Long id, @RequestBody RestCaseCommand command) {
        catalog.updateCase(command.toUpdateCommand(id));
    }

    @Data
    private static class RestCaseCommand {
        private String title;
        private String description;
        private LocalDate date;
        private SecurityLevel securityLevel;
        private StatusCase status;


        CreateCaseCommand toCreateCommand() {
            return new CreateCaseCommand(title, description, date, securityLevel, status);
        }

        UpdateCaseCommand toUpdateCommand(Long id) {
            return new UpdateCaseCommand(id, title, description, date, securityLevel, status);
        }


    }


}
