package com.iivanov791.io;

import com.iivanov791.flight.Flight;
import com.iivanov791.flight.controller.FlightController;

import java.io.*;
import java.text.ParseException;
import java.util.List;

public class FlightIO {

    public void writeFlightsIntoFile(List<Flight> flights, String fileName) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream objOut = new ObjectOutputStream(file);

        flights
                .forEach(flight -> {
            try {
                objOut.writeObject(flight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        objOut.close();
        file.close();
    }

    public void readFlightsFromFile (String fileName) throws IOException, ClassNotFoundException, ParseException {
        FlightController flightController = new FlightController();
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(file);
        Flight flight;

        while (file.available() > 0) {
            flight = (Flight) objIn.readObject();
            flightController.saveFlight(flight);
        }

        objIn.close();
        file.close();
    }
}
