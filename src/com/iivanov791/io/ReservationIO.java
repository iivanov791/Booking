package com.iivanov791.io;
import com.iivanov791.reservation.Reservation;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
* Class ReservationIO responsible for input output reservations from/to local files on the pc. Contains two methods of read and write
* objects.
*
* @version 1.0 10 Mar 2020
*
* @author  Igor Ivanov
* */

public class ReservationIO {

    public void writeReservationsIntoFile(List<Reservation> reservations, String fileName) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream objOut = new ObjectOutputStream(file);

        reservations
                .forEach(reservation -> {
                    try {
                        objOut.writeObject(reservation);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        objOut.close();
        file.close();
    }

    public List<Reservation> readFlightsFromFile (String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(file);
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation;

        while (file.available() > 0) {
            reservation = (Reservation) objIn.readObject();
            reservations.add(reservation);
        }

        objIn.close();
        file.close();
        return reservations;
    }
}
