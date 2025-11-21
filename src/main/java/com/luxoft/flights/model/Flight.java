package com.luxoft.flights.model;

import java.util.Date;
import java.util.Objects;

public class Flight {
    private String tailNum;
    private Date flightDate;
    private Airport origin;
    private Airport destination;
    private Carrier carrier;
    private int depDelay;
    private int arrDelay;
    private int cancelled;

    public Flight(String tailNum, Date flightDate, Airport origin,
                  Airport destination, Carrier carrier,
                  int depDelay, int arrDelay,
                  int cancelled) {
        this.tailNum = tailNum;
        this.flightDate = flightDate;
        this.origin = origin;
        this.destination = destination;
        this.carrier = carrier;
        this.cancelled = cancelled;
        this.depDelay = depDelay;
        this.arrDelay = arrDelay;
    }

    // getters and setters

    public String getTailNum() {
        return tailNum;
    }

    public void setTailNum(String tailNum) {
        this.tailNum = tailNum;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    public int getDepDelay() {
        return depDelay;
    }

    public void setDepDelay(int depDelay) {
        this.depDelay = depDelay;
    }

    public int getArrDelay() {
        return arrDelay;
    }

    public void setArrDelay(int arrDelay) {
        this.arrDelay = arrDelay;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;
        return tailNum == flight.tailNum && Objects.equals(flightDate, flight.flightDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tailNum, flightDate);
    }

    @Override
    public String toString() {
        return "Flight {" +
                "tailNum='" + tailNum + '\'' +
                ", flightDate=" + flightDate +
                ", origin=" + origin +
                ", destination=" + destination +
                ", carrier=" + carrier +
                ", depDelay=" + depDelay +
                ", arrDelay=" + arrDelay +
                ", cancelled=" + cancelled +
                '}';
    }
}
