package com.iivanov791.exceptions;

/*
* NoSuchElementInList Exception appears if searching element doesn't exist in Collection
*
* @version  1.0  10 Mar 2020
*
* @author   Igor Ivanov
*
* */

public class NoSuchElementInList extends RuntimeException {

    public NoSuchElementInList (String message) {
        super (message);
    }
}
