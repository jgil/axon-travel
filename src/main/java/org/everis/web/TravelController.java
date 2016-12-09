package org.everis.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.everis.api.command.BookFlightCommand;
import org.everis.api.command.CreateFlightCommand;
import org.everis.model.FlightDetails;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/travel")
public class TravelController {

    private final CommandGateway commandGateway;

    public TravelController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/book")
    public CompletableFuture<String> book(@RequestBody FlightDetails request) {
        return this.commandGateway.send(new BookFlightCommand(request.getCode(), request.getSeats()));
    }

    @PostMapping("/create")
    public CompletableFuture<String> create(@RequestBody FlightDetails request) {
        return this.commandGateway.send(new CreateFlightCommand(request.getCode(), request.getSeats()));
    }
}
