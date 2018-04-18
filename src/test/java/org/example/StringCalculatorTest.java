package org.example;

import org.example.stringcalculator.NegativeNumberException;
import org.example.stringcalculator.StringCalculator;
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

    @Test
    public void testReturnsSumOfTwoNumbers() {
        String numbers = "1,2";
        int expectedResult = 3;

        int result = StringCalculator.add(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testReturnsSumOfManyNumbers() {
        String numbers = "1,2,3,4,5";
        int expectedResult = 15;

        int result = StringCalculator.add(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testHandlesNewlineDelimiter() {
        String numbers = "1\n2,3";
        int expectedResult = 6;

        int result = StringCalculator.add(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testSupportsCustomDelimiter() {
        String numbers = "//;\n1;2";
        int expectedResult = 3;

        int result = StringCalculator.add(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testThrowsExceptionOnNegativeNumber() {
        String numbers = "//;\n1;-2";

        try {
            StringCalculator.add(numbers);
            fail("Expected NegativeNumberException not thrown.");
        } catch (NegativeNumberException ex) {
        }
    }

}
