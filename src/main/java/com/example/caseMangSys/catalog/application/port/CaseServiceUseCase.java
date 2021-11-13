package com.example.caseMangSys.catalog.application.port;

import com.example.caseMangSys.catalog.domain.Case;
import com.example.caseMangSys.catalog.domain.SecurityLevel;
import com.example.caseMangSys.catalog.domain.StatusCase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

public interface CaseServiceUseCase {
    List<Case> findAll();

    void addCase(CreateCaseCommand command);

    void updateCase(UpdateCaseCommand command);

    void removeById(Long id);


    @Value
    class CreateCaseCommand {
        String title;
        String description;
        LocalDate date;
        SecurityLevel securityLevel;
        StatusCase status;
    }


    @Value
    @Builder
    @AllArgsConstructor
    public class UpdateCaseCommand {
        Long id;
        String title;
        String description;
        LocalDate date;
        SecurityLevel securityLevel;
        StatusCase status;

        public Case updateFields(Case aCase) {
            if (title != null) {
                aCase.setTitle(title);
            }
            if (description != null) {
                aCase.setDescription(description);
            }
            if (date != null) {
                aCase.setDate(date);
            }
            if (securityLevel != null) {
                aCase.setSecurityLevel(securityLevel);
            }
            if (status != null) {
                aCase.setStatusCase(status);
            }
            return aCase;
        }

    }
}
