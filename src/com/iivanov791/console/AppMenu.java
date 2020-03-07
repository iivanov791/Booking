package com.iivanov791.console;

import com.iivanov791.flight.controller.FlightController;
import com.iivanov791.reservation.controller.ReservationController;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppMenu {

    final String FLIGHT_ID = "Please, enter flight ID";
    final String DESTINATION = "Please, enter required destination";
    final String DATE = "Please, enter required date";
    final String REQUIRED_PLACES_NUMBER = "Please, enter required number of places";
    final String OUT_OF_APP = "exit";

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
        MAIN_MENU.put(1, "Display all flights");
        MAIN_MENU.put(2, "Display flight info");
        MAIN_MENU.put(3, "Search flight and make reservation"); // requires Additional Menu
        MAIN_MENU.put(4, "Cancel reservation");
        MAIN_MENU.put(5, "My flights");
    }

    public void fulfillAdditionalMenu () {
        ADDITIONAL_MENU.put(1, "Select Flight");
        ADDITIONAL_MENU.put(2, "Return to Main Menu");
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

//    public void AppRunner() throws ParseException {
//
//        fulfillMainMenu();
//        fulfillAdditionalMenu();
//        Scanner scanner = new Scanner(System.in);
//        String req;
//        String req2;
////        FamilyIO io = new FamilyIO();
////        ArrayList <Family> arr;
//
//        do {
//            displayMainMenuPrettyWay();
//
//            req = scanner.next();
//
//            if (!(req.equalsIgnoreCase(OUT_OF_APP))) {
//                try {
//                    if (Integer.parseInt(req) == 1) {
//                        // read from file and add to data base
//                        familyController.getFamilyService().getFamilyDao().setFamilyList(io.readFamiliesFromFile(scanner.next()));
//                        System.out.println("Successfully: " + familyController.getFamilyService().getFamilyDao().getAllFamilies().size());
//                    } else if (Integer.parseInt(req) == 2) {
//                        if (familyController.getFamilyService().getFamilyDao().getAllFamilies().size() != 0)
//                            familyController.displayAllFamilies();
//                        else
//                            System.out.println(NOTHING_TO_DISPLAY);
//                    } else if (Integer.parseInt(req) == 3) {
//                        System.out.println(GET_REQUIRE_NUMBER);
//                        System.out.println(familyController.getFamiliesBiggerThan(Integer.parseInt(scanner.next())));
//                    } else if (Integer.parseInt(req) == 4) {
//                        System.out.println(GET_REQUIRE_NUMBER);
//                        System.out.println(familyController.getFamiliesLessThan(Integer.parseInt(scanner.next())));
//                    } else if (Integer.parseInt(req) == 5) {
//                        System.out.println(GET_REQUIRE_NUMBER);
//                        System.out.println(familyController.countFamiliesWithMemberNumber(Integer.parseInt(scanner.next())));
//                    } else if (Integer.parseInt(req) == 6) {
//                        System.out.printf(GET_NAME, "mother's");
//                        String maName = scanner.next();
//                        System.out.printf(GET_SURNAME, "mother's");
//                        String maSurname = scanner.next();
//                        System.out.printf(GET_BIRTH_DAY, "mother's");
//                        String maDay = scanner.next();
//                        System.out.printf(GET_BIRTH_MONTH, "mother's");
//                        String maMonth = scanner.next();
//                        System.out.printf(GET_BIRTH_YEAR, "mother's");
//                        String maYear = scanner.next();
//                        String maBirthDay = String.join("/", maDay, maMonth, maYear);
//                        System.out.printf(GET_IQ, "mother's");
//                        int maIqLevel = Integer.parseInt(scanner.next());
//                        Woman ma = new Woman(maName, maSurname, maBirthDay, maIqLevel, new HashMap<>());
//
//                        System.out.printf(GET_NAME, "father's");
//                        String faName = scanner.next();
//                        System.out.printf(GET_SURNAME, "father's");
//                        String faSurname = scanner.next();
//                        System.out.printf(GET_BIRTH_DAY, "father's");
//                        String faDay = scanner.next();
//                        System.out.printf(GET_BIRTH_MONTH, "father's");
//                        String faMonth = scanner.next();
//                        System.out.printf(GET_BIRTH_YEAR, "father's");
//                        String faYear = scanner.next();
//                        String faBirthDay = String.join("/", faDay, faMonth, faYear);
//                        System.out.printf(GET_IQ, "father's");
//                        int faIqLevel = Integer.parseInt(scanner.next());
//                        Man pa = new Man(faName, faSurname, faBirthDay, faIqLevel, new HashMap<>());
//
//                        familyController.createNewFamily(ma, pa);
//                        System.out.println("Success!!!" + familyController.getFamilyService().getFamilyDao().getAllFamilies().size());
//                    } else if (Integer.parseInt(req) == 7) {
//                        System.out.println(GET_FAMILY_ID);
//                        System.out.println(familyController.getFamilyService().getFamilyDao().deleteFamily(Integer.parseInt(scanner.next())));
//                    } else if (Integer.parseInt(req) == 8) {
//
//                        do {
//                            displayAdditionalMenuPrettyWay();
//
//                            req2 = scanner.next();
//
//                            if (Integer.parseInt(req2) == 1) {
//                                System.out.println(GET_FAMILY_ID);
//                                int familyId = Integer.parseInt(scanner.next());
//                                System.out.printf(GET_NAME, "boy's");
//                                String boyName = scanner.next();
//                                System.out.printf(GET_NAME, "girl's");
//                                String girlName = scanner.next();
//                                System.out.println(familyController
//                                        .bornChild(familyController.getFamilyService().getFamilyDao().getFamilyByIndex(familyId - 1),
//                                                boyName, girlName)
//                                        .prettyFormat());
//                            } else if (Integer.parseInt(req2) == 2) {
//                                System.out.println(GET_FAMILY_ID);
//                                int family1Id = Integer.parseInt(scanner.next());
//                                System.out.printf(GET_NAME, "child's");
//                                String name = scanner.next();
//                                System.out.printf(GET_SURNAME, "child's");
//                                String surname = scanner.next();
//                                System.out.printf(GET_BIRTH_DAY, "child's");
//                                String day = scanner.next();
//                                System.out.printf(GET_BIRTH_MONTH, "child's");
//                                String month = scanner.next();
//                                System.out.printf(GET_BIRTH_YEAR, "child's");
//                                String year = scanner.next();
//                                String adoptChildBirthDay = String.join("/", day, month, year);
//                                System.out.printf(GET_IQ, "child's");
//                                int iq = Integer.parseInt(scanner.next());
//                                Human human = new Human(name, surname, adoptChildBirthDay, iq, new HashMap<>());
//                                System.out.println(familyController
//                                        .adoptChild(familyController.getFamilyService().getFamilyDao().getFamilyByIndex(family1Id - 1), human)
//                                        .prettyFormat());
//                            } else {
//                                System.out.println(SORRY_BRO);
//                            }
//
//                        } while (Integer.parseInt(req2) != 3 || !(req2.equalsIgnoreCase(OUT_OF_APP)));
//
//                    } else if (Integer.parseInt(req) == 9) {
//                        System.out.println(GET_REQUIRE_AGE);
//                        familyController.deleteAllChildrenOlderThen(Integer.parseInt(scanner.next()));
//                    } else if (Integer.parseInt(req) == 10) {
//                        System.out.println(GET_FILE_NAME);
//                        // put some logic to write into the file here
//                        io.writeFamiliesIntoFile(familyController.getFamilyService().getFamilyDao().getAllFamilies(), scanner.next());
//                    } else {
//                        System.out.println(SORRY_BRO);
//                    }
//                } catch (NumberFormatException | IOException | ClassNotFoundException ex) {
//                    System.out.println(BRO_BE_SMART + ": " + ex);
//                }
//            }
//        } while (!(req.equalsIgnoreCase(OUT_OF_APP)));
//    }

}
