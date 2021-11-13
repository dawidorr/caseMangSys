package com.example.caseMangSys.catalog.application;

import com.example.caseMangSys.catalog.application.port.CaseServiceUseCase;
import com.example.caseMangSys.catalog.domain.Case;
import com.example.caseMangSys.catalog.domain.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CaseService implements CaseServiceUseCase {

    private final CaseRepository repository;

    public CaseService(CaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Case> findAll() {
        return repository.findAll();
    }


    @Override
    public void addCase(CreateCaseCommand command) {
        Case aCase = new Case(command.getTitle(), command.getDescription(), command.getDate(), command.getSecurityLevel(), command.getStatus());
        repository.save(aCase);

    }

    @Override
    public void removeById(Long id) {
        repository.removeById(id);
    }

    @Override
    public void updateCase(UpdateCaseCommand command) {
        repository
                .findById(command.getId())
                .map(aCase -> {
                    Case updatedCase = command.updateFields(aCase);
                    repository.save(updatedCase);
                    return null;
                });
    }



}
