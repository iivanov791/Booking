package com.iivanov791.reservation;

import com.iivanov791.flight.Flight;
import java.io.Serializable;
import java.util.Objects;

public class Reservation implements Serializable {

    private int ID;
    private String userName;
    private String userSurname;
    private int place;
    private Flight flight;

    private final static long serialVersionUID = 1L;

    public int getID() {
        return ID;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserSurname() {
        return userSurname;
    }
    public int getPlace() {
        return place;
    }
    public Flight getFlight() {
        return flight;
    }

    public Reservation(String userName, String userSurname, Flight flight, int place) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.flight = flight;
        this.ID++;
        this.place = place;
        this.flight.doReservation(this.getPlace(), this);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "Reservation " + getID() +
                "{userName='" + getUserName() + '\'' +
                ", userSurname='" + getUserSurname() + '\'' +
                ", places=" + getPlace() +
                ", flight=" + getFlight().toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return getUserName().equals(that.getUserName()) &&
                getUserSurname().equals(that.getUserSurname()) &&
                getFlight().equals(that.getFlight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserSurname(), getFlight());
    }
}
