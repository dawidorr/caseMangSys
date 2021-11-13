package com.example.caseMangSys.catalog.domain;

import java.util.List;
import java.util.Optional;

public interface CaseRepository {
    List<Case> findAll();

    void save(Case aCase);

    Optional<Case> findById(Long id);

    void removeById(Long id);
}
