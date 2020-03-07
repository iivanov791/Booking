package com.iivanov791.reservation.dao;

import com.iivanov791.flight.Flight;
import com.iivanov791.reservation.Reservation;
import com.iivanov791.reservation.controller.ReservationController;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ReservationDaoTest {

    @Test
    void getAllReservations() throws ParseException {
        ReservationController reservationController = new ReservationController();
        Flight flight = new Flight ("08/03/2020 15:30", "Kyiv",
                "New York City", 255);
        reservationController.saveReservation(new Reservation("Igor", "Ivanov", flight, 1));
        reservationController.saveReservation(new Reservation("Alla", "Pugacheva", flight, 3));
        reservationController.saveReservation(new Reservation("Dima", "Bilan", flight, 3));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight, 15));
        assertEquals(4, reservationController.getAllReservations().size());
    }

    @Test
    void saveReservation() throws ParseException {
        ReservationController reservationController = new ReservationController();
        Flight flight = new Flight ("08/03/2020 15:30", "Kyiv",
                "New York City", 255);
        reservationController.saveReservation(new Reservation("Igor", "Ivanov", flight, 1));
        reservationController.saveReservation(new Reservation("Alla", "Pugacheva", flight, 3));
        reservationController.saveReservation(new Reservation("Dima", "Bilan", flight, 3));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight, 15));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight, 15));
        assertEquals(4, reservationController.getAllReservations().size());
    }

    @Test
    void deleteReservation() throws ParseException {
        ReservationController reservationController = new ReservationController();
        Flight flight = new Flight ("08/03/2020 15:30", "Kyiv",
                "New York City", 255);
        reservationController.saveReservation(new Reservation("Igor", "Ivanov", flight, 1));
        reservationController.saveReservation(new Reservation("Alla", "Pugacheva", flight, 3));
        reservationController.saveReservation(new Reservation("Dima", "Bilan", flight, 3));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight, 15));
        assertTrue(reservationController.deleteReservation(3));
        assertEquals(3, reservationController.getAllReservations().size());
    }
}