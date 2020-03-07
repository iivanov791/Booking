package com.iivanov791.flight.dao;

import com.iivanov791.flight.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDao {

    private List <Flight> flights;

    public FlightDao() {
        this.flights = new ArrayList<>();
    }

    public List <Flight> getAllFlights () {
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
