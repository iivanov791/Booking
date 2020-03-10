package com.iivanov791.flight.service;
import com.iivanov791.exceptions.UnavailableToFindException;
import com.iivanov791.flight.Flight;
import com.iivanov791.flight.dao.FlightDao;
import java.util.ArrayList;
import java.util.List;

/*
* Class Flight Service allows to do operations with flights inside the Flights Collection in flightDao field
*
* @verion 1.0 10 Mar 2020
*
* @author Igor Ivanov
* */

public class FlightService {

    private FlightDao flightDao;

    public FlightDao getFlightDao() {
        return flightDao;
    }

    public FlightService() {
        this.flightDao = new FlightDao();
    }

    final String WARNING = "No flights which matched your inputed data";

    /*
    * throw to console result of searching in flights Data Base
    * */

    public void onlineFlightTable () {
        flightDao
                .getAllFlights()
                .stream()
                .filter(flight -> flight.getDeparturePlace().equals("Kyiv"))
                .filter(Flight::getTimeToFlight)
                .forEach(flight -> System.out.println(flight.toString()));
    }

    /*
    * returns String of flights which match to conditions passed
    * */

    public String searchFlight (String destination, String date, int number) {
        ArrayList <Flight> flights = new ArrayList<>();
        flightDao
                .getAllFlights()
                .stream()
                .filter(flight -> flight.getArrivingPlace().equals(destination))
                .filter(flight -> flight.getFormattedDepartureTime().equals(date))
                .filter(flight -> flight.getFreePlaces() > number)
                .forEach(flights::add);
        if (flights.size() > 0) {
            return String.valueOf(flights);
        } else {
            return String.valueOf(new UnavailableToFindException(WARNING));
        }
    }

    /*
    * this method allows to load to data base List of Flights, not one Flight as in saveFlight method
    * */

    public void loadData (List<Flight> flights) {
        flights.forEach(flight -> flightDao.saveFlight(flight));
    }
}
