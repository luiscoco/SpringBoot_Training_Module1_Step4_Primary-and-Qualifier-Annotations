package com.luxoft.flights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("dbDataLoader")
public class DatabaseLoader implements DataLoader {

    private final DataService dataService;

    @Autowired
    public DatabaseLoader(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void loadData() throws Exception {
        // Placeholder for database loading logic
        System.out.println("Database loader selected. Implement DB loading here.");
    }
}
