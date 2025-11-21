package com.luxoft.flights.services;

import com.luxoft.flights.model.Airport;
import com.luxoft.flights.model.Carrier;
import com.luxoft.flights.model.Flight;
import com.luxoft.flights.model.State;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DataService {
    private final List<Flight> flights = new ArrayList<>();
    private final Set<Airport> airports = new HashSet<>();
    private final Set<Carrier> carriers = new HashSet<>();
    private final Set<State> states = new HashSet<>();

    public void saveFlight(Flight flight) {
        flights.add(flight);
    }

    public void saveAirport(Airport airport) {
        airports.add(airport);
    }

    public void saveCarrier(Carrier carrier) {
        carriers.add(carrier);
    }

    public void saveState(State state) {
        states.add(state);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public Set<Carrier> getCarriers() {
        return carriers;
    }

    public Set<State> getStates() {
        return states;
    }

    public List<Flight> getFlightsByOrigin(String airportCode) {
        return flights.stream()
                .filter(flight -> flight.getOrigin().getAirportCode().equals(airportCode))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsByCarrier(String carrierCode) {
        return flights.stream()
                .filter(flight -> flight.getCarrier().getCode().equals(carrierCode))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightsByState(String stateName) {
        return flights.stream()
                .filter(flight -> flight.getOrigin().getState().getName().equals(stateName) ||
                        flight.getDestination().getState().getName().equals(stateName))
                .collect(Collectors.toList());
    }
}
