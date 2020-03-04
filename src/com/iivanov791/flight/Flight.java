package com.iivanov791.flight;

import com.iivanov791.reservation.Reservation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
*
* */

public class Flight {
    // here must store Date, not String for date and time. But when creating new Flight user passes String to it constructor.
    // So you must cast this String to Date via Setter
    private String date;
    private String time;
    private String departurePlace;
    private String arrivingPlace;
    private int placesAll;
    private Map <Integer, Reservation> reservationMap = new HashMap<>(placesAll);

//    private final String DATE_FORMAT = "dd/mm/yyyy";

    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getDeparturePlace() {
        return departurePlace;
    }
    public String getArrivingPlace() {
        return arrivingPlace;
    }
    public int getPlacesAll() {
        return placesAll;
    }
    public Map<Integer, Reservation> getReservationMap() {
        return reservationMap;
    }

//    public LocalDate setDate(String date) throws ParseException {
//        // put some logic about casting String to date here
//        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
//        LocalDate flightDate = LocalDate.parse(date, format);
//        return flightDate.get
//    }
//    public LocalDate setTime(String time) {
//        // put some logic about casting String to date here
//    }

    public Flight(String date, String time, String departurePlace, String arrivingPlace, int placesAll) {
        this.date = date;
        this.time = time;
        this.departurePlace = departurePlace;
        this.arrivingPlace = arrivingPlace;
        this.placesAll = placesAll;
    }

    public int getFreePlaces () {
        return getPlacesAll() - getReservationMap().size();
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "Flight{" +
                "date=" + getDate() +
                ", time=" + getTime() +
                ", Departure Place='" + getDeparturePlace() + '\'' +
                ", Arriving Place='" + getArrivingPlace() + '\'' +
                ", Free PLaces=" + getFreePlaces() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getDate().equals(flight.getDate()) &&
                getTime().equals(flight.getTime()) &&
                getDeparturePlace().equals(flight.getDeparturePlace()) &&
                getArrivingPlace().equals(flight.getArrivingPlace()) &&
                getReservationMap().equals(flight.getReservationMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTime(), getDeparturePlace(), getArrivingPlace(), getReservationMap());
    }
}
