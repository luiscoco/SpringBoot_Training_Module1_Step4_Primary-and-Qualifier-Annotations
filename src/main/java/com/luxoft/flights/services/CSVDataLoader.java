package com.luxoft.flights.services;

import com.luxoft.flights.model.Airport;
import com.luxoft.flights.model.Carrier;
import com.luxoft.flights.model.Flight;
import com.luxoft.flights.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@Qualifier("csvDataLoader")
@Primary
public class CSVDataLoader implements DataLoader {

    private final DataService dataService;

    @Autowired
    public CSVDataLoader(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void loadData() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("flights_small.csv"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

        // Skip the first line
        lines = lines.subList(1, lines.size());

        for (String line : lines) {
            // skip empty lines
            if (line.isEmpty()) continue;

            String[] fields = line.split(",");

            State state = new State(fields[7]);
            dataService.saveState(state);

            Airport origin = new Airport(Integer.parseInt(fields[5]), fields[6], state);
            dataService.saveAirport(origin);

            Airport destination = new Airport(Integer.parseInt(fields[8]), fields[9], state);
            dataService.saveAirport(destination);

            Carrier carrier = new Carrier(fields[3]); // Map the code to the name
            dataService.saveCarrier(carrier);

            int depDelay = 0;
            if (!fields[12].isEmpty()) {
                depDelay = Integer.parseInt(fields[12]);
            }
            int arrDelay = 0;
            if (!fields[16].isEmpty()) {
                arrDelay = Integer.parseInt(fields[16]);
            }
            Flight flight = new Flight(
                    fields[4],
                    dateFormat.parse(fields[2]),
                    origin,
                    destination,
                    carrier,
                    depDelay,
                    arrDelay,
                    Integer.parseInt(fields[17]) // cancelled status
            );
            dataService.saveFlight(flight);
        }
    }
}
