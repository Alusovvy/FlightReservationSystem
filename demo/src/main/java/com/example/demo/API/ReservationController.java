package com.example.demo.API;

import com.example.demo.Model.Reservation;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.ResolveResult;
import java.util.ArrayList;

@RequestMapping("api/v1/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity addReservation(@RequestBody Reservation reservation) {
        if (reservationService.addReservation(reservation) == true) {
            return ResponseEntity.ok(reservation);
        }

        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(400).body("Incorret values");
    }


    @DeleteMapping
    public ResponseEntity deleteReservation(@RequestBody Reservation reservation) {


        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        int id = reservation.getReservation_id();
        if (reservationService.deleteReservation(id) == true) {
            return ResponseEntity.ok(reservation);
        }

        return ResponseEntity.status(400).body("Incorret values");
    }

    @PutMapping
    public ResponseEntity updateReservation(@RequestBody Reservation reservation) {
        if (reservationService.updateReservation(reservation) == true) {
            return ResponseEntity.ok(reservation);
        }

        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(400).body("Incorret values");
    }

    @GetMapping
    public ResponseEntity getReservation(@RequestBody Reservation reservation) {
        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        int id = reservation.getReservation_id();

        Reservation res = reservationService.getReservation(id);

        if (res != null) {
            return ResponseEntity.ok(res);
        }

        return ResponseEntity.status(400).body("Incorrect id");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getReservations(@RequestBody Reservation reservation) {
        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        int id = reservation.getReservation_id();

        ArrayList<Reservation> res = reservationService.getReservations(id);

        if (res != null) {
            return ResponseEntity.ok(res);
        }

        return ResponseEntity.status(400).body("Incorrect id");
    }

}
