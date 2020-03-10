package com.iivanov791.console;

import com.iivanov791.exceptions.NoSuchElementInList;
import com.iivanov791.exceptions.NoSuchVariantException;
import com.iivanov791.exceptions.UnavailableToFindException;
import com.iivanov791.flight.controller.FlightController;
import com.iivanov791.io.FlightIO;
import com.iivanov791.io.ReservationIO;
import com.iivanov791.reservation.Reservation;
import com.iivanov791.reservation.controller.ReservationController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Class AppMenu main method runner(), via which the Booking Application available to run it's code
 *
 * @version 1.0  10 Mar 2020
 *
 * @author  Igor Ivanov
 * */

public class AppMenu {

    final String FLIGHT_ID = "Please, enter flight ID";
    final String DESTINATION = "Please, enter required destination";
    final String RESERVATION_ID = "Please, enter reservation ID";
    final String DATE = "Please, enter required date";
    final String REQUIRED_PLACES_NUMBER = "Please, enter required number of places";
    final String OUT_OF_APP = "exit";
    final String NAME = "Please, enter passenger name";
    final String SURNAME = "Please, enter passenger surname";
    final String NO_VARIANT = "Bro, the variant you inputed doesn't exist in this Menu. Please, choose valid option";
    final String OUT_OF_BOUND = "Sorry, this flight doesn't exist";
    final String BRO_BE_SMART = "Bro, please enter valid value";

    private final Map<Integer, String> MAIN_MENU;
    public ReservationController reservationController;
    public FlightController flightController;

    public Map<Integer, String> getMAIN_MENU() {
        return MAIN_MENU;
    }

    public AppMenu() {
        this.MAIN_MENU = new HashMap<>();
        this.reservationController = new ReservationController();
        this.flightController = new FlightController();
    }

    public void fulfillMainMenu () {
        MAIN_MENU.put(1, "Display next 24 hours flights");
        MAIN_MENU.put(2, "Display flight info");
        MAIN_MENU.put(3, "Search flight and make reservation");
        MAIN_MENU.put(4, "Cancel reservation");
        MAIN_MENU.put(5, "My flights");
    }

    public void displayMainMenuPrettyWay() {
        for (Map.Entry<Integer, String> li : getMAIN_MENU().entrySet()) {
            System.out.printf("- %d : %s\n", li.getKey(), li.getValue());
        }
    }

    public void runner () throws IOException, ClassNotFoundException, NoSuchVariantException, NumberFormatException,
            NoSuchElementInList, UnavailableToFindException {
        File file = new File ("AppSessionFlights.txt");
        File file1 = new File ("AppSessionReservations.txt");
        fulfillMainMenu();
        Scanner scanner = new Scanner(System.in);
        String request;
        FlightIO flightIO = new FlightIO();
        ReservationIO reservationIO = new ReservationIO();

        if (file.exists() && file1.exists()) {
            flightController.loadData(flightIO.readFlightsFromFile("C:\\JavaProjects\\MyStepByOwn\\AppSessionFlights.txt"));
            reservationController.loadData(reservationIO.readFlightsFromFile("C:\\JavaProjects\\MyStepByOwn\\AppSessionReservations.txt"));
        } else {
           flightController.loadData(flightIO.readFlightsFromFile("C:\\JavaProjects\\MyStepByOwn\\FlightsDataBase.txt"));
           reservationController.loadData(reservationIO.readFlightsFromFile("C:\\JavaProjects\\MyStepByOwn\\ReservationsDataBase.txt"));
        }

            do {
                displayMainMenuPrettyWay();
                request = scanner.next();

                    if (!(request.equalsIgnoreCase(OUT_OF_APP))) {
                        try {
                            if (Integer.parseInt(request) == 1) {
                                flightController.onlineFlightTable();
                            } else if (Integer.parseInt(request) == 2) {
                                System.out.println(FLIGHT_ID);
                                int id = Integer.parseInt(scanner.next());
                                if (flightController.getAllFlights().size() < id | id <= 0) {
                                    throw new NoSuchElementInList(OUT_OF_BOUND);
                                } else {
                                    System.out.println(flightController.getAllFlights().get(id-1).toString());
                                }
                            } else if (Integer.parseInt(request) == 3) {
                                System.out.println(DESTINATION);
                                String destination = scanner.next();
                                System.out.println(DATE);
                                String date = scanner.next();
                                System.out.println(REQUIRED_PLACES_NUMBER);
                                int number = Integer.parseInt(scanner.next());

                                System.out.println(flightController.searchFlight(destination, date, number));

                                System.out.println(FLIGHT_ID);

                                int id1 = Integer.parseInt(scanner.next());
                                if (id1 == 0) {
                                    continue;
                                } else {
                                    for (int i = 0; i < number; i++) {
                                        System.out.println(NAME);
                                        String name = scanner.next();
                                        System.out.println(SURNAME);
                                        String surname = scanner.next();

                                        reservationController.saveReservation(new Reservation(name, surname,
                                                flightController.getAllFlights().get(id1-1)));
                                        System.out.println(flightController.getAllFlights().get(id1-1).toString());
                                    }

                                }
                            } else if (Integer.parseInt(request) == 4) {
                                System.out.println(NAME);
                                String name = scanner.next();
                                System.out.println(SURNAME);
                                String surname = scanner.next();
                                reservationController.searchReservationsOfSpecifiedPerson(name, surname);

                                System.out.println(RESERVATION_ID);
                                int id = Integer.parseInt(scanner.next());
                                System.out.println(reservationController.deleteReservation(id-1));
                            } else if (Integer.parseInt(request) == 5) {
                                System.out.println(NAME);
                                String name = scanner.next();
                                System.out.println(SURNAME);
                                String surname = scanner.next();
                                reservationController.searchReservationsOfSpecifiedPerson(name, surname);
                            } else {
                                throw new NoSuchVariantException(NO_VARIANT);
                            }
                        } catch (NoSuchVariantException | NoSuchElementInList | UnavailableToFindException ex) {
                            System.out.println(ex.getMessage());
                        } catch (NumberFormatException ex) {
                            System.out.println(BRO_BE_SMART + ex.getMessage());
                        }
                    }

            } while (!request.equalsIgnoreCase(OUT_OF_APP));


        flightIO.writeFlightsIntoFile(flightController.getAllFlights(), "AppSessionFlights.txt");
        reservationIO.writeReservationsIntoFile(reservationController.getAllReservations(), "AppSessionReservations.txt");
    }
}
