package com.iivanov791.flight;

import com.iivanov791.reservation.Reservation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/*
* Class Flight contains 7 private fields, one of them is reservationList -> which contains all the reservations for this flight.
* Two final Strings using for 4 Flight methods, also contains 3 overrided methods of toString(), equals() and hashcode();
*
* @version 1.0  10 Mar 2020
*
* @author  Igor Ivanov
* */

public class Flight implements Serializable {

    private int ID;
    private long departureTime;
    private String departurePlace;
    private String arrivingPlace;
    private int placesAll;
    private List<Reservation> reservationList = new ArrayList<>(placesAll);

    private final static long serialVersionUID = 1L;
    final String DATE_FORMAT = "dd/MM/yyyy hh:mm";
    final String PLACE_IS_TAKEN = "Sorry, all places already taken. Choose another flight \n";


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
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setID (int ID) {
        this.ID = ID;
    }

    public Flight(String departureTime, String departurePlace, String arrivingPlace, int placesAll) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        Date date = format.parse(departureTime);
        this.departureTime = date.getTime();
        this.departurePlace = departurePlace;
        this.arrivingPlace = arrivingPlace;
        this.placesAll = placesAll;
    }

    /*
    *  this mathod return number of free Places on the flight
    * */
    public int getFreePlaces () {
        int counter = 0;
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i) != null) {
                counter++;
            }
        }
        return placesAll - counter;
    }

    /*
    *  this method allows to do Reservation on the flight
    * */
    public void doReservation (Reservation reservation) {
       if (this.getFreePlaces() > 0) {
           this.reservationList.add(reservation);
       } else {
           System.out.println(PLACE_IS_TAKEN);
       }
    }

    /*
    * this method return boolean if it is less than 25 hours before the flight, than this method returns true, else - returns false
    * */
    public boolean getTimeToFlight () {
        Date date = new Date();
        Date date1 = new Date(this.getDepartureTime());
        long diff = date1.getTime() - date.getTime();
        return (int) (diff / (60*60*1000)) < 25;
    }

    /*
    *  this method returns String of date value, converted from private long departure Time field
    * */
    public String getFormattedDepartureTime() {
        Timestamp time = new Timestamp(this.getDepartureTime());
        LocalDateTime t = time.toLocalDateTime();
        StringBuilder strBld = new StringBuilder();
        return String.valueOf(strBld
                .append(t.getDayOfMonth())
                .append("/")
                .append(t.getMonth().getValue())
                .append("/")
                .append(t.getYear()));
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " Flight ID: "  + getID() +
                "{Departure Time=" + getFormattedDepartureTime() +
                ", Departure Place='" + getDeparturePlace() + '\'' +
                ", Arriving Place='" + getArrivingPlace() + '\'' +
                ", Free Places=" + getFreePlaces() + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getDeparturePlace().equals(flight.getDeparturePlace()) &&
                getArrivingPlace().equals(flight.getArrivingPlace()) &&
                getReservationList().equals(flight.getReservationList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeparturePlace(), getArrivingPlace(), getReservationList());
    }
}
