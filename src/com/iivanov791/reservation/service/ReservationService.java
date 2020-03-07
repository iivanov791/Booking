package com.iivanov791.reservation.service;

import com.iivanov791.reservation.dao.ReservationDao;

public class ReservationService {

    private ReservationDao reservationDao;

    public ReservationService() {
        this.reservationDao = new ReservationDao();
    }

    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    // Put some logic here
    // for example, person puts its name and surname, than this method tries to find all reservations, made by this person
    public void searchReservationsOfSpecifiedPerson (String name, String surname) {
        reservationDao
                .getAllReservations()
                .stream()
                .filter(reservation -> reservation.getUserName().equals(name))
                .filter(reservation -> reservation.getUserSurname().equals(surname))
                .forEach(reservation -> System.out.println(reservation.toString()));
    }
}
