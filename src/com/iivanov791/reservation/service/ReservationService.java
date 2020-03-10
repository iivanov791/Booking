package com.iivanov791.reservation.service;

import com.iivanov791.reservation.Reservation;
import com.iivanov791.reservation.dao.ReservationDao;
import java.util.List;

/*
* Class ReservationService contains instance of ReservationDao, via which it is able to work with reservations Data Base. Contains
* two void methods searchReservationsOfSpecifiedPerson -> takes two strings: name and surname and throws to Console result of searching
* in Collection by this two parameters, and loadData -> takes List of Reservations and loads it to the Data Base
*
* @version 1.0 10 Mar 2020
*
* @author  Igor Ivanov
*
* */

public class ReservationService {

    private ReservationDao reservationDao;

    public ReservationService() {
        this.reservationDao = new ReservationDao();
    }

    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    public void searchReservationsOfSpecifiedPerson (String name, String surname) {
        reservationDao
                .getAllReservations()
                .stream()
                .filter(reservation -> reservation.getUserName().equals(name))
                .filter(reservation -> reservation.getUserSurname().equals(surname))
                .forEach(reservation -> System.out.println(reservation.toString()));
    }

    public void loadData (List<Reservation> reservations) {
        reservations.forEach(reservation -> reservationDao.saveReservation(reservation));
    }
}
