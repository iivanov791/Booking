package com.iivanov791.exceptions;

/*
 * NoSuchVariantException appears if user inputs the number, which is not present option in Menu
 *
 * @version  1.0  10 Mar 2020
 *
 * @author   Igor Ivanov
 *
 * */

public class NoSuchVariantException extends RuntimeException {

    public NoSuchVariantException (String message) {
        super(message);
    }
}
