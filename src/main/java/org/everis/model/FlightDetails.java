package org.everis.model;

import java.util.Date;

public class FlightDetails {
   public String code;
   public Integer seats;

    public FlightDetails() {
    }

    public FlightDetails(String code, Integer seats) {
        this.code = code;
        this.seats = seats;
    }

    public String getCode() {
        return code;
    }

    public Integer getSeats() {
        return seats;
    }

}
