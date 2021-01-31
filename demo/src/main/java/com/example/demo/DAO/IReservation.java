package com.example.demo.DAO;

import com.example.demo.Model.Reservation;

import java.util.List;

public interface IReservation {
    boolean addReservation(Reservation reservation);
    boolean updateReservation(Reservation reservation);
    boolean deleteReservation(int id);
    Reservation getReservation(int reservation_id);
    List<Reservation> getReservations(int id);
}
