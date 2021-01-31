package com.example.demo.service;

import com.example.demo.DAO.ReservationDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.Model.Reservation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReservationService {
    private final ReservationDAO reservationDAO;

    public ReservationService(@Qualifier("ReservationDAO") ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }

    public boolean addReservation(Reservation reservation) {
        return reservationDAO.addReservation(reservation);

    }

    public boolean updateReservation(Reservation reservation) {
        return reservationDAO.updateReservation(reservation);
    }

    public boolean deleteReservation(int id) {
        return reservationDAO.deleteReservation(id);
    }

    public Reservation getReservation(int id) {
        return reservationDAO.getReservation(id);
    }

    public ArrayList<Reservation> getReservations(int id) {
        return reservationDAO.getReservations(id);
    }
}
