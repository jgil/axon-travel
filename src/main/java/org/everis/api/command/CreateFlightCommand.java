package org.everis.api.command;

public class CreateFlightCommand {

    private final String code;
    private final Integer seats;

    public CreateFlightCommand(String code, Integer seats) {
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
