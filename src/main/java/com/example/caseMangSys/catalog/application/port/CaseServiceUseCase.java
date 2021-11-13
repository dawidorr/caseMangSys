package com.example.caseMangSys.catalog.application.port;

import com.example.caseMangSys.catalog.domain.Case;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Collections;
import java.util.List;

public interface CaseServiceUseCase {
    List<Case> findAll();

    void addCase(CreateCaseCommand command);

    void updateCase(UpdateCaseCommand command);

    void removeById(Long id);

//    @Value
//    class UpdateCaseResponse {
//        public static UpdateCaseResponse SUCCESS = new UpdateCaseResponse(true, Collections.emptyList());
//
//        boolean success;
//        List<String> errors;
//    }

    @Value
    class CreateCaseCommand {
        String title;
        String description;
        String date;
        String securityLevel;
        String status;
    }


    @Value
    @Builder
    @AllArgsConstructor
    public class UpdateCaseCommand {
        Long id;
        String title;
        String description;
        String date;
        String securityLevel;
        String status;

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
                aCase.setStatus(status);
            }
            return aCase;
        }

    }
}
