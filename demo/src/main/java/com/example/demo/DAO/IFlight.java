package com.example.demo.DAO;

import com.example.demo.Model.Flight;

import java.sql.Date;
import java.util.ArrayList;

public interface IFlight {
     boolean addFlight(Flight flight);
     boolean updateFlight(Flight flight);
     boolean deleteFlight(Flight flight);
     Flight getFlight(int id);
     ArrayList<Flight> getFlights(String arrival_location, String departure_location, Date departure_time);
     ArrayList<Flight> getFlights(String arrival_location, String departure_location);
     ArrayList<Flight> getFlights();
}
