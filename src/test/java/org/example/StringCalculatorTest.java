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
}
