package com.iivanov791.flight.service;

import com.iivanov791.flight.Flight;
import com.iivanov791.flight.dao.FlightDao;
import java.text.ParseException;

public class FlightService {

    private FlightDao flightDao;

    public FlightDao getFlightDao() {
        return flightDao;
    }

    public FlightService() {
        this.flightDao = new FlightDao();
    }

    final String WARNING = "Bro, please enter date correctly";

    // Put some logic here to find all flights from Kyiv which will go next 24 hours till this moment
    // for exmple: now is 05 March 2020 13:00
    // Find all flights till 06 March 2020 13:00
    public void onlineFlightTable () {
        flightDao
                .getAllFlights()
                .stream()
                .filter(flight -> flight.getDeparturePlace().equals("Kyiv"))
                .filter(Flight::getTimeToFlight)
                .forEach(flight -> System.out.println(flight.toString()));
    }

    public void searchFlight (String destination, String date, int number) {
        flightDao
                .getAllFlights()
                .stream()
                .filter(flight -> flight.getArrivingPlace().equals(destination))
                .filter(flight -> flight.getFormattedDepartureTime().equals(date))
                .filter(flight -> flight.getFreePlaces() > number)
                .forEach(flight -> System.out.println(flight.toString()));
    }
}
