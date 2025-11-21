package com.luxoft.flights.model;

import java.util.Objects;

public class Carrier {
    private String code;
    private String name;

    public Carrier(String code) {
        this.code = code;
        if (code.equals("AA")) {
            this.name = "America Airlines";
        } else if (code.equals("WN")) {
            this.name = "Southwest Airlines";
        }
    }

    // getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrier carrier = (Carrier) o;
        return Objects.equals(code, carrier.code) && Objects.equals(name, carrier.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(code);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}

