package com.example.demo.API;

import com.example.demo.Model.Flight;
import com.example.demo.service.FlightService;
import com.example.demo.service.ReservationService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("api/v1/flight")
@RestController
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity addFlight(@RequestBody Flight flight) {
        if (flight == null) {
            return ResponseEntity.status(400).body(null);
        }

        if (flightService.addFlight(flight)) {
            return ResponseEntity.ok(flight);
        }

        return ResponseEntity.status(400).body("Wrong inputs");
    }

    @PutMapping
    public ResponseEntity updateFlight(@RequestBody Flight flight) {
        if (flight == null) {
            return ResponseEntity.status(400).body(null);
        }

        if (flightService.updateFlight(flight)) {
            return ResponseEntity.ok(flight);
        }

        return ResponseEntity.status(400).body("Wrong inputs");
    }

    @DeleteMapping
    public ResponseEntity deleteFlight(@RequestBody Flight flight) {
        if (flight == null) {
            return ResponseEntity.status(400).body(null);
        }

        if (flightService.deleteFlight(flight)) {
            return ResponseEntity.ok(flight);
        }

        return ResponseEntity.status(400).body("Wrong id");
    }

    @GetMapping
    public ResponseEntity getFlight(@RequestBody Flight flight) {
        if (flight == null) {
            return ResponseEntity.status(400).body(null);
        }
        int id = flight.getFlight_id();

        Flight flightRec = flightService.getFlight(id);

        if (flightRec == null) {
            return ResponseEntity.status(400).body(null);
        }

        return ResponseEntity.ok(flightRec);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all1")
    public ResponseEntity getFlights(@RequestBody Flight flight) {
        if (flight == null) {
            return ResponseEntity.status(400).body("no infomration provided");
        }

        ArrayList<Flight> flights = flightService.getFlights(flight.getArrival_location(), flight.getDeparture_location(), flight.getDeparture_time());

        return ResponseEntity.ok(flights);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all2")
    public ResponseEntity getFlights2(@RequestBody Flight flight) {
        if (flight == null) {
            return ResponseEntity.status(400).body("no infomration provided");
        }

        ArrayList<Flight> flights = flightService.getFlights(flight.getArrival_location(), flight.getDeparture_location());

        return ResponseEntity.ok(flights);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all3")
    public ResponseEntity getFlights() {
        ArrayList<Flight> flights = flightService.getFlights();

        return ResponseEntity.ok(flights);
    }
}
