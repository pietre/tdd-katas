package org.example.stringcalculator;

public class NegativeNumberException extends IllegalArgumentException {

    NegativeNumberException() {
        super("Negative numbers are not allowed.");
    }

}
