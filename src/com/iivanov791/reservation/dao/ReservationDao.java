package com.iivanov791.reservation.dao;

import com.iivanov791.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDao {

    private List<Reservation> reservations;

    public ReservationDao() {
        this.reservations = new ArrayList<>();
    }

    public List <Reservation> getAllReservations () {
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
