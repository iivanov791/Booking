package com.iivanov791;
import com.iivanov791.console.AppMenu;
import java.io.IOException;
/*
* Class BookingApp let the application start running
*
* @version 1.0  10 Mar 2020
*
* @author  Igor Ivanov
* */
public class BookingApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AppMenu appMenu = new AppMenu();
        appMenu.runner();

    }
}
