package com.iivanov791.reservation.controller;

import com.iivanov791.reservation.Reservation;
import com.iivanov791.reservation.service.ReservationService;

import java.util.List;

public class ReservationController {

    public ReservationService reservationService;

    public ReservationController() {
        this.reservationService = new ReservationService();
    }

    public List<Reservation> getAllReservations () {
        return reservationService.getReservationDao().getAllReservations();
    }

    public void saveReservation(Reservation reservation) {
        reservationService.getReservationDao().saveReservation(reservation);
    }

    public boolean deleteReservation(int index) {
        return reservationService.getReservationDao().deleteReservation(index);
    }
}
