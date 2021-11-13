package com.example.caseMangSys.catalog.infrastructure;

import com.example.caseMangSys.catalog.domain.Case;
import com.example.caseMangSys.catalog.domain.CaseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryCaseRepository implements CaseRepository {
    private final Map<Long, Case> storage = new ConcurrentHashMap<>();
    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(0L);

    @Override
    public List<Case> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void save(Case aCase) {
        if(aCase.getId()!=null){
            storage.put(aCase.getId(),aCase);
        }else{
            long nextId = nextId();
            aCase.setId(nextId);
            storage.put(nextId,aCase);
        }
    }

    @Override
    public Optional<Case> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void removeById(Long id) {
        storage.remove(id);
    }

    private long nextId(){
        return ID_NEXT_VALUE.getAndIncrement();
    }

}
