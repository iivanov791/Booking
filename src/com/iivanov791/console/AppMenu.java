package com.iivanov791.console;

import com.iivanov791.flight.controller.FlightController;
import com.iivanov791.io.FlightIO;
import com.iivanov791.io.ReservationIO;
import com.iivanov791.reservation.controller.ReservationController;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppMenu {

    final String FLIGHT_ID = "Please, enter flight ID";
    final String DESTINATION = "Please, enter required destination";
    final String DATE = "Please, enter required date";
    final String REQUIRED_PLACES_NUMBER = "Please, enter required number of places";
    final String OUT_OF_APP = "exit";
    final String NAME = "Please, enter passenger name";
    final String SURNAME = "Please, enter passenger surname";

    private final Map<Integer, String> MAIN_MENU;
    private final Map<Integer, String> ADDITIONAL_MENU;
    public ReservationController reservationController;
    public FlightController flightController;

    public Map<Integer, String> getMAIN_MENU() {
        return MAIN_MENU;
    }
    public Map<Integer, String> getADDITIONAL_MENU() {
        return ADDITIONAL_MENU;
    }

    public AppMenu() {
        this.MAIN_MENU = new HashMap<>();
        this.ADDITIONAL_MENU = new HashMap<>();
        this.reservationController = new ReservationController();
        this.flightController = new FlightController();
    }

    public void fulfillMainMenu () {
        MAIN_MENU.put(1, "Display next 24 hours flights");
        MAIN_MENU.put(2, "Display flight info");
        MAIN_MENU.put(3, "Search flight and make reservation"); // requires Additional Menu
        MAIN_MENU.put(4, "Cancel reservation");
        MAIN_MENU.put(5, "My flights");
    }

    public void fulfillAdditionalMenu () {
        ADDITIONAL_MENU.put(0, "Return to Main Menu");
        ADDITIONAL_MENU.put(1, "Select Flight");
    }

    public void displayMainMenuPrettyWay() {
        for (Map.Entry<Integer, String> li : getMAIN_MENU().entrySet()) {
            System.out.printf("- %d : %s\n", li.getKey(), li.getValue());
        }
    }

    public void displayAdditionalMenuPrettyWay() {
        for (Map.Entry<Integer, String> li : getADDITIONAL_MENU().entrySet()) {
            System.out.printf("- %d : %s\n", li.getKey(), li.getValue());
        }
    }

    public void runner () {
        fulfillMainMenu();
        displayMainMenuPrettyWay();
        fulfillAdditionalMenu();
        Scanner scanner = new Scanner(System.in);
        String request;
        String request1;
        FlightIO flightIO = new FlightIO();
        ReservationIO reservationIO = new ReservationIO();

        do {
            displayMainMenuPrettyWay();
            request = scanner.next();

            if (!request.equalsIgnoreCase(OUT_OF_APP)) {
                if (Integer.parseInt(request) == 1) {
                    flightController.onlineFlightTable();
                } else if (Integer.parseInt(request) == 2) {
                    System.out.println(FLIGHT_ID);
                    System.out.println(flightController.getAllFlights().get(Integer.parseInt(scanner.next())).toString());
                } else if (Integer.parseInt(request) == 3) {
                    System.out.println(DESTINATION);
                    String destination = scanner.next();
                    System.out.println(DATE);
                    String date = scanner.next();
                    System.out.println(REQUIRED_PLACES_NUMBER);
                    int number = Integer.parseInt(scanner.next());

                    flightController.searchFlight(destination, date, number);

                        System.out.println(FLIGHT_ID);
                        // need some time to think of strategy here
                        request1 = scanner.next();
                        if (Integer.parseInt(request1) == 0) {
                            displayMainMenuPrettyWay();
                        } else {
                            displayAdditionalMenuPrettyWay();

                        }
                }
            }

        } while (!request.equalsIgnoreCase(OUT_OF_APP));
    }
}
