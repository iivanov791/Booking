package com.iivanov791.flight.controller;

import com.iivanov791.flight.Flight;
import com.iivanov791.flight.service.FlightService;

import java.util.List;

/*
 * Class Flight Controller serve for purposes of DAO-Service-Controller pattern. It contains instance of flightService via which
 * it works with all methods of service and dao classes
 *
 * @verion 1.0 10 Mar 2020
 *
 * @author Igor Ivanov
 * */

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

    public String searchFlight (String destination, String date, int number) {
        return this.flightService.searchFlight(destination, date, number);
    }

    public void loadData (List<Flight> flights) {
        flightService.loadData(flights);
    }

}
