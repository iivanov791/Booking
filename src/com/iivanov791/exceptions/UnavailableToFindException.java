package com.iivanov791.exceptions;

/*
 * UnavailableToFindException appears if it is impossible to find element by condition passed
 *
 * @version  1.0  10 Mar 2020
 *
 * @author   Igor Ivanov
 *
 * */

public class UnavailableToFindException extends RuntimeException {

    public UnavailableToFindException (String message) {
        super(message);
    }
}
