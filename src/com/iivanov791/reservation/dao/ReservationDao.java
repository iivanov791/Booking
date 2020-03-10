package com.iivanov791.reservation.dao;

import com.iivanov791.reservation.Reservation;
import java.util.ArrayList;
import java.util.List;
/*
* Class ReservationDao contains Collection of Reservations which is need to work with Flight Application. Here we have 3 methods via which
* we can getAllReservations() -> returns List of Reservations, saveReservation by one reservation passed and deleteReservation by its index
*
* @version 1.0  10 Mar 2020
*
* @author  Igor Ivanov
* */

public class ReservationDao {

    private List<Reservation> reservations;

    public ReservationDao() {
        this.reservations = new ArrayList<>();
    }

    public List <Reservation> getAllReservations () {
        reservations.forEach(reservation -> reservation.setID(reservations.indexOf(reservation) + 1));
        return reservations;
    }

    public void saveReservation(Reservation reservation) {
        if (reservations.contains(reservation)) {
            reservations.set(reservations.indexOf(reservation), reservation);
        } else {
            reservations.add(reservation);
        }
    }

    public boolean deleteReservation(int index) {
        if (!(index > (reservations.size() - 1))) {
            reservations.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
