package org.example.stringcalculator;

import java.util.List;

public class NegativeNumberException extends IllegalArgumentException {

    NegativeNumberException(List<String> negativeNumbers) {
        super("Negative numbers are not allowed, encountered: "
                + String.join(", ", negativeNumbers)
                + ".");
    }

}
