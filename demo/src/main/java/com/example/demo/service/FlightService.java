package com.example.demo.service;

import com.example.demo.DAO.FlightDAO;
import com.example.demo.DAO.ReservationDAO;
import com.example.demo.Model.Flight;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Service
public class FlightService {
    private final FlightDAO flightDAO;

    public FlightService(@Qualifier("FlightDAO") FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public boolean addFlight(Flight flight) {
        return flightDAO.addFlight(flight);
    }

    public boolean updateFlight(Flight flight) {
        return flightDAO.updateFlight(flight);
    }

    public boolean deleteFlight(Flight flight) {
        return flightDAO.deleteFlight(flight);
    }

    public Flight getFlight(int id) {
        return flightDAO.getFlight(id);
    }

    public ArrayList<Flight> getFlights(String arrival_location, String departure_location, String departure_time) {
        return flightDAO.getFlights(arrival_location, departure_location, departure_time);
    }

    public ArrayList<Flight> getFlights(String arrival_location, String departure_location) {
        return flightDAO.getFlights(arrival_location, departure_location);
    }

    public ArrayList<Flight> getFlights() {
        return flightDAO.getFlights();
    }
}
