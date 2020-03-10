package com.iivanov791.io;

import com.iivanov791.flight.Flight;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Class FlightIO responsible for input output flights from/to local files on the pc. Contains two methods of read and write
 * objects.
 *
 * @version 1.0 10 Mar 2020
 *
 * @author  Igor Ivanov
 * */

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

    public List<Flight> readFlightsFromFile (String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream objIn = new ObjectInputStream(file);
        List<Flight> flights = new ArrayList<>();
        Flight flight;

        while (file.available() > 0) {
            flight = (Flight) objIn.readObject();
            flights.add(flight);
        }

        objIn.close();
        file.close();
        return flights;
    }
}
