package com.iivanov791.flight.controller;

import com.iivanov791.flight.Flight;
import com.iivanov791.flight.service.FlightService;

import java.util.List;

public class FlightController {

    public FlightService flightService;

    public FlightController() {
        this.flightService = new FlightService();
    }

    public List<Flight> getAllFlights () {
        return flightService.getFlightDao().getAllFlights();
    }

    public void saveFlight(Flight flight) {
       flightService.getFlightDao().saveFlight(flight);
    }

    public boolean deleteFlight(int index) {
        return flightService.getFlightDao().deleteFlight(index);
    }

    public void onlineFlightTable () {
        this.flightService.onlineFlightTable();
    }

    public void searchFlight (String destination, String date, int number) {
        this.flightService.searchFlight(destination, date, number);
    }
}
