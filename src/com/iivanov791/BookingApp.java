package com.iivanov791;

import com.iivanov791.flight.Flight;
import com.iivanov791.reservation.Reservation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class BookingApp {

    public static void main(String[] args) throws ParseException {


        Flight flight1 = new Flight("11/03/2020 15:00", "Kyiv", "Roma", 145);
        Flight flight2 = new Flight("11/03/2020 15:30", "Kyiv", "Barcelona", 115);
        Flight flight3 = new Flight("11/03/2020 16:00", "Kyiv", "Lisbon", 130);
        Flight flight4 = new Flight("11/03/2020 17:00", "Kyiv", "Porto", 155);
        Flight flight5 = new Flight("11/03/2020 18:00", "Kyiv", "Madrid", 165);
        Flight flight6 = new Flight("11/03/2020 19:00", "Kyiv", "Paris", 125);
        Flight flight7 = new Flight("11/03/2020 20:00", "Kyiv", "Marseille", 100);
        Flight flight8 = new Flight("11/03/2020 21:00", "Kyiv", "London", 200);
        Flight flight9 = new Flight("11/03/2020 22:00", "Kyiv", "Milano", 200);
        Flight flight10 = new Flight("11/03/2020 23:00", "Kyiv", "Torino", 140);
        Flight flight11 = new Flight("11/03/2020 23:30", "Kyiv", "Berlin", 196);
        Flight flight12 = new Flight("11/03/2020 19:44", "Kyiv", "Nursultan", 210);
        Flight flight13 = new Flight("11/03/2020 17:00", "Kyiv", "Belgrad", 110);
        Flight flight14 = new Flight("11/03/2020 15:00", "Kyiv", "Istanbul", 220);
        Flight flight15 = new Flight("11/03/2020 04:00", "Kyiv", "Athens", 180);
        Flight flight16 = new Flight("12/03/2020 03:00", "Kyiv", "Stockholm", 170);
        Flight flight17 = new Flight("12/03/2020 02:00", "Kyiv", "Reykjavik", 114);
        Flight flight18 = new Flight("12/03/2020 01:00", "Kyiv", "Copenhagen", 160);
        Flight flight19 = new Flight("13/03/2020 15:00", "Kyiv", "Oslo", 150);
        Flight flight20 = new Flight("13/03/2020 16:00", "Kyiv", "Helsinki", 140);
        Flight flight21 = new Flight("13/03/2020 17:00", "Kyiv", "Riga", 145);
        Flight flight22 = new Flight("14/03/2020 20:00", "Kyiv", "Talinn", 120);
        Flight flight23 = new Flight("14/03/2020 21:00", "Kyiv", "Prague", 165);
        Flight flight24 = new Flight("14/03/2020 19:00", "Kyiv", "Warsaw", 175);
        Flight flight25 = new Flight("15/03/2020 14:00", "Kyiv", "Krakow", 141);
        Flight flight26 = new Flight("15/03/2020 15:00", "Kyiv", "Vienna", 168);
        Flight flight27 = new Flight("15/03/2020 16:00", "Kyiv", "Bern", 110);
        Flight flight28 = new Flight("17/03/2020 17:00", "Kyiv", "Geneve", 115);
        Flight flight29 = new Flight("16/03/2020 14:00", "Kyiv", "New York", 200);
        Flight flight30 = new Flight("17/03/2020 13:00", "Kyiv", "Tel Aviv", 200);
        Flight flight31 = new Flight("16/03/2020 21:00", "Kyiv", "Antalya", 165);
        Flight flight32 = new Flight("16/03/2020 20:00", "Kyiv", "Erevan", 125);
        Flight flight33 = new Flight("18/03/2020 21:00", "Kyiv", "Minsk", 130);
        Flight flight34 = new Flight("18/03/2020 22:00", "Kyiv", "Vilnius", 110);
        Flight flight35 = new Flight("18/03/2020 20:00", "Kyiv", "Alma-Aty", 175);
        Flight flight36 = new Flight("18/03/2020 19:00", "Kyiv", "Beijing", 186);
        Flight flight37 = new Flight("19/03/2020 16:00", "Kyiv", "Wuhan", 185);
        Flight flight38 = new Flight("19/03/2020 17:00", "Kyiv", "Guangzhou", 199);
        Flight flight39 = new Flight("19/03/2020 18:00", "Kyiv", "Seoul", 198);
        Flight flight40 = new Flight("19/03/2020 19:00", "Kyiv", "Teheran", 168);
        Flight flight41 = new Flight("20/03/2020 17:00", "Kyiv", "Sofia", 140);
        Flight flight42 = new Flight("20/03/2020 18:00", "Kyiv", "Budapest", 145);
        Flight flight43 = new Flight("20/03/2020 19:00", "Kyiv", "Cairo", 185);
        Flight flight44 = new Flight("21/03/2020 17:00", "Kyiv", "Hurgada", 195);
        Flight flight45 = new Flight("21/03/2020 14:00", "Kyiv", "Sharm El-Sheikh", 195);
        ArrayList <Flight> flights = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8,
                flight9, flight10, flight11, flight12, flight13, flight14, flight15, flight16, flight17, flight18, flight19, flight20, flight21,
                flight22, flight23, flight24, flight25, flight26, flight27, flight28, flight29, flight30, flight31, flight32, flight33, flight34,
                flight35, flight36, flight37, flight38, flight39, flight40, flight41, flight42, flight43, flight44, flight45));

        Reservation reservation = new Reservation("Igor", "Ivanov", flight1, 44);
        Reservation reservation1 = new Reservation("Oksana", "Musiienko", flight1, 43);
        Reservation reservation2 = new Reservation("Alla", "Pugacheva", flight2, 22);
        Reservation reservation3 = new Reservation("Maksim", "Galkin", flight2, 23);
        Reservation reservation4 = new Reservation("Maksym", "Omelyan", flight3, 14);
        Reservation reservation5 = new Reservation("Alona", "Omelyan", flight3, 15);
        Reservation reservation6 = new Reservation("Oleksandr", "Musiienko", flight4, 1);
        Reservation reservation7 = new Reservation("Kateryna", "Stroyin", flight4, 2);
        Reservation reservation8 = new Reservation("Vladimir", "Shafirko", flight5, 56);
        Reservation reservation9 = new Reservation("Vladimir", "Sobchuk", flight5, 69);
        Reservation reservation10 = new Reservation("Aleksandr", "Filipovych", flight5, 78);
        Reservation reservation11 = new Reservation("Igor", "Ivanov", flight6, 99);
        Reservation reservation12 = new Reservation("Norma", "Rhidus", flight7, 115);
        Reservation reservation13 = new Reservation("Danai", "Gurira", flight8, 55);
        Reservation reservation14 = new Reservation("Petro", "Poroshenko", flight8, 58);
        Reservation reservation15 = new Reservation("Volodymyr", "Zelenskiy", flight8, 66);
        Reservation reservation16 = new Reservation("Donald", "Trump", flight9, 88);
        Reservation reservation17 = new Reservation("Kim Cheng", "Yn", flight9, 99);
        Reservation reservation18 = new Reservation("Si", "Jingping", flight9, 101);
        Reservation reservation19 = new Reservation("George", "Soros", flight10, 1);
        Reservation reservation20 = new Reservation("Les", "Podervlyanskiy", flight10, 2);
        Reservation reservation21 = new Reservation("Juhym", "Ostapchuk", flight11, 33);
        Reservation reservation22 = new Reservation("Kozak", "Gavryliuk", flight11, 12);
        Reservation reservation23 = new Reservation("Sergey", "Borodach", flight11, 12);
        Reservation reservation24 = new Reservation("Katya", "Ivanova", flight12, 3);
        Reservation reservation25 = new Reservation("Snezhana", "Surikova", flight12, 5);
        Reservation reservation26 = new Reservation("Valentina", "Pavlova", flight13, 10);
        Reservation reservation27 = new Reservation("Vladlena", "Lazebnaya", flight13, 11);
        Reservation reservation28 = new Reservation("Dmitriy", "Dgangirov", flight14, 12);
        Reservation reservation29 = new Reservation("Rodion", "Lipatov", flight14, 13);
        Reservation reservation30 = new Reservation("Denys", "Matviyenko", flight14, 15);
        Reservation reservation31 = new Reservation("Sasha", "Avramenko", flight15, 1);
        Reservation reservation32 = new Reservation("Nikolay", "Osipenko", flight15, 2);
        Reservation reservation33 = new Reservation("Orest", "Shegda", flight15, 4);
        Reservation reservation34 = new Reservation("Dmitriy", "Pryyma", flight16, 11);
        Reservation reservation35 = new Reservation("Sergey", "Portnov", flight16, 22);
        Reservation reservation36 = new Reservation("Marina", "Sherman", flight17, 77);
        Reservation reservation37 = new Reservation("Tofik", "Bahramov", flight17, 55);
        Reservation reservation38 = new Reservation("Aleksandr", "Arnold", flight18, 2);
        Reservation reservation39 = new Reservation("Garik", "Korogodskiy", flight18, 4);
        Reservation reservation40 = new Reservation("Nesmertan", "Jo", flight19, 33);
        Reservation reservation41 = new Reservation("Aleks", "Bersheda", flight19, 11);
        Reservation reservation42 = new Reservation("Lyubov", "Semen", flight20, 1);
        Reservation reservation43 = new Reservation("Carolina", "Korol", flight20, 11);
        Reservation reservation44 = new Reservation("Igor", "Ivanov", flight20, 45);
        Reservation reservation45 = new Reservation("Vitaliy", "Sagan", flight20, 111);
        ArrayList<Reservation> reservations = new ArrayList<>(Arrays.asList(reservation, reservation1, reservation2, reservation3,
                reservation4, reservation5, reservation6, reservation7, reservation8, reservation9, reservation10, reservation11,
                reservation12, reservation13, reservation14, reservation15, reservation16, reservation17, reservation18, reservation19,
                reservation20, reservation21, reservation22, reservation23, reservation24, reservation25, reservation26, reservation27,
                reservation28, reservation29, reservation30, reservation31, reservation32, reservation33, reservation34, reservation35,
                reservation36, reservation37, reservation38, reservation39, reservation40, reservation41, reservation42, reservation43,
                reservation44, reservation45));
    }
}
