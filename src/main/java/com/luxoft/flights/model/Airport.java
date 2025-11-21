package com.luxoft.flights.model;

public class Airport {
    private int airportID;
    private String airportCode;
    private State state;

    public Airport(int airportID, String airportCode, State state) {
        this.airportID = airportID;
        this.airportCode = airportCode;
        this.state = state;
    }

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;
        return airportID == airport.airportID;
    }

    @Override
    public int hashCode() {
        return airportID;
    }

    @Override
    public String toString() {
        return airportCode;
    }
}

