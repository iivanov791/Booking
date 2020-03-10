package com.iivanov791.flight.dao;

import com.iivanov791.flight.Flight;

import java.util.ArrayList;
import java.util.List;

/*
 * Class Flight Dao contains Collection of Flights and allows to get this collection, save Flight into Collection and delete Flight
 * via passing index of Flight
 *
 * @verion 1.0 10 Mar 2020
 *
 * @author Igor Ivanov
 * */

public class FlightDao {

    private List <Flight> flights;

    public FlightDao() {
        this.flights = new ArrayList<>();
    }

    public List <Flight> getAllFlights () {
        flights.forEach(flight -> flight.setID(flights.indexOf(flight) + 1));
        return flights;
    }

    public void saveFlight(Flight flight) {
        if (flights.contains(flight)) {
            flights.set(flights.indexOf(flight), flight);
        } else {
            flights.add(flight);
        }
    }

    public boolean deleteFlight(int index) {
        if (!(index > (flights.size() - 1))) {
            flights.remove(index);
            return true;
        } else {
            return false;
        }
    }
}
