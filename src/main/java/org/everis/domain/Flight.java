package org.everis.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;
import org.everis.api.command.BookFlightCommand;
import org.everis.api.command.CreateFlightCommand;
import org.everis.api.event.FlightBookedEvent;
import org.everis.api.event.FlightCreatedEvent;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Flight {

    @AggregateIdentifier
    private String code;
    private Integer capacity;

    public Flight() {
    }

    @CommandHandler
    public Flight(CreateFlightCommand command) {
        System.out.println(">>> CreateFlightCommand");
        apply(new FlightCreatedEvent(command.getCode(), command.getSeats()));
    }

    @CommandHandler
    public void bookFlight(BookFlightCommand command) {
        System.out.println(">>> BookFlightCommand");
        apply(new FlightBookedEvent(command.getCode(), command.getSeats()));
    }

    @EventSourcingHandler
    protected void on(FlightCreatedEvent event) {
        System.out.println(">>> FlightCreatedEvent");
        this.code = event.getCode();
        this.capacity = event.getSeats();
    }

    @EventSourcingHandler
    protected void on(FlightBookedEvent event) {
        System.out.println(">>> FlightBookedEvent");
        this.code = event.getCode();
    }
}
