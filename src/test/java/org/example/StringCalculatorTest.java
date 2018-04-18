package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void testReturnsZeroForEmptyString() {
        String numbers = "";
        int expectedResult = 0;

        int result = StringCalculator.add(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testReturnsNumberForSingleNumber() {
        String numbers = "1";
        int expectedResult = 1;

        int result = StringCalculator.add(numbers);

        assertEquals(expectedResult, result);
    }


}
