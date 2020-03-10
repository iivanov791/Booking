package com.iivanov791.reservation.controller;

import com.iivanov791.reservation.Reservation;
import com.iivanov791.reservation.service.ReservationService;
import java.util.List;

/*
* Class ReservationController serve for purposes of DAO-Service-Controller pattern. It contains instance of reservationService via which
* it works with all methods of service and dao classes
*
* @version 1.0  10 Mar 2020
*
* @author  Igor Ivanov
* */

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

    public void loadData (List<Reservation> reservations) {
        reservationService.loadData(reservations);
    }

    public void searchReservationsOfSpecifiedPerson (String name, String surname) {
        reservationService.searchReservationsOfSpecifiedPerson(name, surname);
    }
}
