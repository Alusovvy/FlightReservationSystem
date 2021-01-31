package com.example.demo.service;

import com.example.demo.DAO.FlightDAO;
import com.example.demo.DAO.ReservationDAO;
import com.example.demo.Model.Flight;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
