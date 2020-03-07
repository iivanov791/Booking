package com.iivanov791.flight.dao;

import com.iivanov791.flight.Flight;
import com.iivanov791.flight.controller.FlightController;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class FlightDaoTest {

    @Test
    void getAllFlights() throws ParseException {
        FlightController flightController = new FlightController();
        flightController.saveFlight(new Flight("08/03/2020 19:45", "Roma",
                "Milano", 100));
        flightController.saveFlight(new Flight("09/03/2020 16:00", "Milano",
                "Amsterdam", 150));
        flightController.saveFlight(new Flight("15/07/2020 14:00", "London",
                "Reykjavik", 100));
        flightController.saveFlight(new Flight("16/10/2020 01:00", "Lisboa",
                "Vladivostok", 150));
        assertEquals(4, flightController.getAllFlights().size());
    }

    @Test
    void saveFlight() throws ParseException {
        FlightController flightController = new FlightController();
        flightController.saveFlight(new Flight("07/03/2020 19:00", "Kyiv",
                "Barcelona", 200));
        flightController.saveFlight(new Flight("07/03/2020 19:00", "Kyiv",
                "Barcelona", 200));
        assertEquals(1, flightController.getAllFlights().size());
    }

    @Test
    void deleteFlight() throws ParseException {
        FlightController flightController = new FlightController();
        flightController.saveFlight(new Flight("08/03/2020 19:45", "Roma",
                "Milano", 100));
        flightController.saveFlight(new Flight("09/03/2020 16:00", "Milano",
                "Amsterdam", 150));
        flightController.saveFlight(new Flight("15/07/2020 14:00", "London",
                "Reykjavik", 100));
        flightController.saveFlight(new Flight("16/10/2020 01:00", "Lisboa",
                "Vladivostok", 150));

        assertTrue(flightController.deleteFlight(0));
        assertEquals(3, flightController.getAllFlights().size());
    }
}