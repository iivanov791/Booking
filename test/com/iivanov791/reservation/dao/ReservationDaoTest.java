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
        reservationController.saveReservation(new Reservation("Igor", "Ivanov", flight));
        reservationController.saveReservation(new Reservation("Alla", "Pugacheva", flight));
        reservationController.saveReservation(new Reservation("Dima", "Bilan", flight));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight));
        assertEquals(4, reservationController.getAllReservations().size());
    }

    @Test
    void saveReservation() throws ParseException {
        ReservationController reservationController = new ReservationController();
        Flight flight = new Flight ("08/03/2020 15:30", "Kyiv",
                "New York City", 255);
        reservationController.saveReservation(new Reservation("Igor", "Ivanov", flight));
        reservationController.saveReservation(new Reservation("Alla", "Pugacheva", flight));
        reservationController.saveReservation(new Reservation("Dima", "Bilan", flight));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight));
        assertEquals(4, reservationController.getAllReservations().size());
    }

    @Test
    void deleteReservation() throws ParseException {
        ReservationController reservationController = new ReservationController();
        Flight flight = new Flight ("08/03/2020 15:30", "Kyiv",
                "New York City", 255);
        reservationController.saveReservation(new Reservation("Igor", "Ivanov", flight));
        reservationController.saveReservation(new Reservation("Alla", "Pugacheva", flight));
        reservationController.saveReservation(new Reservation("Dima", "Bilan", flight));
        reservationController.saveReservation(new Reservation("Mika", "Newton", flight));
        assertTrue(reservationController.deleteReservation(3));
        assertEquals(3, reservationController.getAllReservations().size());
    }
}