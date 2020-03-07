package com.iivanov791.io;
import com.iivanov791.reservation.Reservation;
import com.iivanov791.reservation.controller.ReservationController;

import java.io.*;
import java.text.ParseException;
import java.util.List;

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

    public void readFlightsFromFile (String fileName) throws IOException, ClassNotFoundException, ParseException {
        ReservationController reservationController = new ReservationController();
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(file);
        Reservation reservation;

        while (file.available() > 0) {
            reservation = (Reservation) objIn.readObject();
            reservationController.saveReservation(reservation);
        }

        objIn.close();
        file.close();
    }
}
