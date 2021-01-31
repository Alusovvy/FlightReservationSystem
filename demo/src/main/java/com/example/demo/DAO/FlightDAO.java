package com.example.demo.DAO;

import com.example.demo.Model.Flight;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository("FlightDAO")
public class FlightDAO implements IFlight {
    public static ConnectionString conStr = new ConnectionString();
    private String connString = conStr.getConnStr();;

    @Override
    public boolean addFlight(Flight flight) {
        try (
                Connection conn = DriverManager.getConnection(
                        connString
                )) {
            String query = "INSERT INTO flights (flight_number, departure_time, arrival_time, departure_location, arrival_location, flight_price) VALUES (?,?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, flight.getFlight_number());
            stmt.setString(2, flight.getDeparture_time());
            stmt.setString(3, flight.getArrival_time());
            stmt.setString(4, flight.getDeparture_location());
            stmt.setString(5, flight.getArrival_location());
            stmt.setFloat(6, flight.getPrice());

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

        @Override
    public boolean updateFlight(Flight flight) {
            try (
                    Connection conn = DriverManager.getConnection(
                            connString
                    )) {
                String query = "UPDATE flights SET flight_number = ?, departure_time = ?, arrival_time = ?, departure_location = ? , arrival_location = ?, flight_price = ? WHERE flight_id = ?";

                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, flight.getFlight_number());
                stmt.setString(2, flight.getDeparture_time());
                stmt.setString(3, flight.getArrival_time());
                stmt.setString(4, flight.getDeparture_location());
                stmt.setString(5, flight.getArrival_location());
                stmt.setFloat(6, flight.getPrice());
                stmt.setInt(7, flight.getFlight_id());

                int rows = stmt.executeUpdate();

                if (rows > 0) {
                    return true;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return false;
    }

    @Override
    public boolean deleteFlight(Flight flight) {

        int id = flight.getFlight_id();

        try (
                Connection conn = DriverManager.getConnection(
                        conStr.connStr
                )) {
            String query = "DELETE FROM flights WHERE flight_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }
        @Override
    public Flight getFlight(int id) {
            try (
                    Connection conn = DriverManager.getConnection(
                            conStr.connStr
                    )) {

                Flight flight = new Flight();

                String query = "SELECT * FROM flights WHERE flight_id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, id);

                ResultSet result = stmt.executeQuery();
                result.next();
                if (result != null) {
                    flight.setFlight_number(result.getInt("flight_number"));
                    flight.setDeparture_time(result.getString("departure_time"));
                    flight.setArrival_time(result.getString("arrival_time"));
                    flight.setDeparture_location(result.getString("arrival_location"));
                    flight.setArrival_location(result.getString("arrival_location"));
                    flight.setPrice(result.getFloat("flight_price"));
                    flight.setFlight_id(id);

                    return flight;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return null;
    }

    @Override
    public ArrayList<Flight> getFlights(String arrival_location, String departure_location, Date departure_time) {
        return null;
    }

    @Override
    public ArrayList<Flight> getFlights(String arrival_location, String departure_location) {
        return null;
    }

    @Override
    public ArrayList<Flight> getFlights() {
        return null;
    }
}
