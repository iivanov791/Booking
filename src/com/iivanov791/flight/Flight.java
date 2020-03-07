package com.iivanov791.flight;

import com.iivanov791.reservation.Reservation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
*
* */

public class Flight implements Serializable {

    private int ID;
    private long departureTime;
    private String departurePlace;
    private String arrivingPlace;
    private int placesAll;
    private Map <Integer, Reservation> reservationMap = new HashMap<>(placesAll);

    private final static long serialVersionUID = 1L;
    final String DATE_FORMAT = "dd/MM/yyyy hh:mm";
    final String PLACE_IS_TAKEN = "Sorry, place %d is taken. Choose another place \n";
    final String OUT_OF_BOUND = "Sorry, place %d doesn't exist, while maximum capacity is %d";

    public int getID() {
        return ID;
    }
    public long getDepartureTime () {
        return departureTime;
    }
    public String getDeparturePlace() {
        return departurePlace;
    }
    public String getArrivingPlace() {
        return arrivingPlace;
    }
    public Map<Integer, Reservation> getReservationMap() {
        return reservationMap;
    }

    public Flight(String departureTime, String departurePlace, String arrivingPlace, int placesAll) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        Date date = format.parse(departureTime);
        this.departureTime = date.getTime();
        this.departurePlace = departurePlace;
        this.arrivingPlace = arrivingPlace;
        this.placesAll = placesAll;
        this.ID++;
        for (int i = 1; i <= placesAll; i++) {
            this.reservationMap.put(i, null);
        }
    }

    public int getFreePlaces () {
        int counter = 0;
        for (int i = 1; i <= reservationMap.size(); i++) {
            if (reservationMap.get(i) == null) {
                counter++;
            }
        }
        return counter;
    }

    public void doReservation (int place, Reservation reservation) {
       if (this.reservationMap.get(place) != null) {
           System.out.printf(PLACE_IS_TAKEN, place);
       } else if (place > this.reservationMap.size()) {
           System.out.printf(OUT_OF_BOUND, place, this.placesAll);
       } else {
           this.reservationMap.put(place, reservation);
       }
    }

    public boolean getTimeToFlight () {
        Date date = new Date();
        Date date1 = new Date(this.getDepartureTime());
        long diff = date1.getTime() - date.getTime();
        return (int) (diff / (60*60*1000)) <= 24;
    }

    public String getFormattedDepartureTime() {
        Timestamp time = new Timestamp(this.getDepartureTime());
        LocalDateTime t = time.toLocalDateTime();
        StringBuilder strBld = new StringBuilder();
        return String.valueOf(strBld
                .append(t.getDayOfMonth())
                .append("/")
                .append(t.getMonth().getValue())
                .append("/")
                .append(t.getYear())
                .append(" ")
                .append(t.getHour())
                .append(":")
                .append(t.withMinute(t.getMinute()).toString().substring(14)));
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "Flight " + getID() +
                " {Departure Time=" + getFormattedDepartureTime() +
                ", Departure Place='" + getDeparturePlace() + '\'' +
                ", Arriving Place='" + getArrivingPlace() + '\'' +
                ", Free PLaces=" + getFreePlaces() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getDeparturePlace().equals(flight.getDeparturePlace()) &&
                getArrivingPlace().equals(flight.getArrivingPlace()) &&
                getReservationMap().equals(flight.getReservationMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeparturePlace(), getArrivingPlace(), getReservationMap());
    }
}
