package com.example.demo.DAO;

import com.example.demo.Model.Flight;
import com.example.demo.Model.Reservation;
import com.example.demo.Model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository("ReservationDAO")
public class ReservationDAO implements IReservation {
    public static ConnectionString conStr = new ConnectionString();
    private String connString = conStr.getConnStr();;


    @Override
    public boolean addReservation(Reservation reservation) {
        try
                (
                Connection conn = DriverManager.getConnection(
                        connString
                )) {
            String query = "INSERT INTO reservations (user_id, flight_id, cargo_weight) VALUES (?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, reservation.getUser_id());
            stmt.setInt(2, reservation.getFlight_id());
            stmt.setInt(3, reservation.getCargo_weight());


            int rows = stmt.executeUpdate();

            if(rows > 0) {
                return true;
            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean updateReservation(Reservation reservation) {
        try
                (
                        Connection conn = DriverManager.getConnection(
                                connString
                        )) {
            String query = "UPDATE reservations SET cargo_weight = ? WHERE reservation_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, reservation.getCargo_weight());
            stmt.setInt(2, reservation.getReservation_id());


            int rows = stmt.executeUpdate();

            if(rows > 0) {
                return true;
            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteReservation(int id) {
        try
                (
                        Connection conn = DriverManager.getConnection(
                                connString
                        )) {
            String query = "DELETE FROM reservations WHERE reservation_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, id);


            int rows = stmt.executeUpdate();

            if(rows > 0) {
                return true;
            }

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    //todo
    @Override
    public Reservation getReservation(int reservation_id) {

        Reservation reservation = new Reservation();
        Flight flight = new Flight();
        User user = new User(null,null,null,null,null,null, 0,null);

        try
                (
                        Connection conn = DriverManager.getConnection(
                                connString
                        )) {
            String query = "SELECT * FROM reservations JOIN flights ON reservations.flight_id = flights.flight_id JOIN users ON reservations.user_id = users.user_id WHERE reservations.reservation_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, reservation_id);

            ResultSet result = stmt.executeQuery();
            result.next();
            if (result == null) {
                return null;
            }

            user.setUser_id(result.getInt("user_id"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setFirst_name(result.getString("first_name"));
            user.setLast_name(result.getString("last_name"));
            user.setDOB(result.getString("DOB"));
            user.setAge(result.getInt("age"));
            user.setNationality(result.getString("nationality"));
            user.setGender(result.getString("gender"));

            flight.setFlight_number(result.getInt("flight_number"));
            flight.setDeparture_time(result.getString("departure_time"));
            flight.setArrival_time(result.getString("arrival_time"));
            flight.setDeparture_location(result.getString("arrival_location"));
            flight.setArrival_location(result.getString("arrival_location"));
            flight.setPrice(result.getFloat("flight_price"));

            reservation.setCargo_weight(result.getInt("cargo_weight"));

            reservation.setFlight(flight);
            reservation.setUser(user);

        }


        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return reservation;

    }

    @Override
    public List<Reservation> getReservations(int id) {
        return null;
    }
}
