package org.everis.api.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class BookFlightCommand {

    private final String code;
    private final Integer seats;

    public BookFlightCommand(String code, Integer seats) {
        this.code = code;
        this.seats = seats;
    }

    @TargetAggregateIdentifier
    public String getCode() {
        return code;
    }

    public Integer getSeats() {
        return seats;
    }
}
