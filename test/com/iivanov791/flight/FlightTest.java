package com.iivanov791.flight;

import com.iivanov791.reservation.Reservation;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    public int fulfillFlight () throws ParseException {
        Flight flight = new Flight("14/03/2020 20:00", "Kyiv", "Buharest", 196);
        Reservation reservation = new Reservation("Igor", "Ivanov", flight);
        Reservation reservation1 = new Reservation("Oksana", "Musiienko", flight);
        System.out.println(flight.getReservationList());
        return flight.getFreePlaces();
    }

    @Test
    void getFreePlaces() throws ParseException {
        Flight flight = new Flight("14/03/2020 19:00", "Kyiv", "Roma", 298);
        assertEquals(298, flight.getFreePlaces());
        assertEquals(194, fulfillFlight());
    }

    @Test
    void getTimeToFlight () throws ParseException {
        Flight flight = new Flight ("11/03/2020 15:00", "Kyiv", "Vienna", 160);
        assertTrue(flight.getTimeToFlight());
    }

    @Test
    void getFormattedDepartureTime () throws ParseException {
        Flight flight = new Flight("09/03/2020 15:00", "Kyiv", "Stockholm", 140);
        String str = "9/3/2020";
        assertEquals(str, flight.getFormattedDepartureTime());
    }

}