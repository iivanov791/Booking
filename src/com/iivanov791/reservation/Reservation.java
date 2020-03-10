package com.iivanov791.reservation;

import com.iivanov791.flight.Flight;
import java.io.Serializable;
import java.util.Objects;

/*
* Class Reservation consists of 4 fields: ID, userName, userSurname and Flight. To Create the instance of it u need to input name, surname
* and instance of Flight. Also this class contains overrided to String(), equals() and hashCode();
*
* @version 1.0 10 Mar 2020
*
* @author  Igor Ivanov
* */

public class Reservation implements Serializable {

    private int ID;
    private String userName;
    private String userSurname;
    private Flight flight;

    private final static long serialVersionUID = 1L;

    public int getID () {
        return ID;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserSurname() {
        return userSurname;
    }
    public Flight getFlight() {
        return flight;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Reservation(String userName, String userSurname, Flight flight) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.flight = flight;
        this.flight.doReservation(this);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "Reservation ID: " + getID() +
                " {userName='" + getUserName() + '\'' +
                ", userSurname='" + getUserSurname() + '\'' +
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
