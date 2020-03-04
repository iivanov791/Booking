package com.iivanov791.reservation;

import com.iivanov791.flight.Flight;

import java.util.Objects;

public class Reservation {

    private String userName;
    private String userSurname;
    private int place;
    private Flight flight;

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
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//    public void setUserSurname(String userSurname) {
//        this.userSurname = userSurname;
//    }
//    public void setPlace(int place) {
//        this.place = place;
//    }
//    public void setFlight(Flight flight) {
//        this.flight = flight;
//    }

    public Reservation(String userName, String userSurname, Flight flight) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "userName='" + getUserName() + '\'' +
                ", userSurname='" + getUserSurname() + '\'' +
                ", place=" + getPlace() +
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
