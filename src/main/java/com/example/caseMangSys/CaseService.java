package com.example.caseMangSys;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class CaseService {
    private final Map<Long,Case> storage = new ConcurrentHashMap<>();

    public CaseService(){
        storage.put(1L,new Case(1L,"Computer accident","Computer not working","12/11/2021","low","new"));
        storage.put(2L,new Case(1L,"Service accident","Service not working","12/11/2021","low","new"));
        storage.put(3L,new Case(1L,"Database accident","Database not working","12/11/2021","low","new"));
    }

    List<Case> findByTitle(String title){
        return storage.values()
                .stream()
                .filter(aCase -> aCase.title.startsWith(title))
                .collect(Collectors.toList());

    }
}
