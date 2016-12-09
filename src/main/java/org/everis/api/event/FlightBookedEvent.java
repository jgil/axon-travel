package org.everis.api.event;

public class FlightBookedEvent {
    private final String code;
    private final Integer seats;

    public FlightBookedEvent(String code, Integer seats) {
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
