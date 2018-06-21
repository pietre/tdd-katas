package org.example;

import org.example.timeformatter.TimeFormatter;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeFormatterTest {

    @Test
    public void returnsSingleSecond() {
        int seconds = 1;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("1 second", result);
    }

    @Test
    public void returnsManySecond() {
        int seconds = 20;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("20 seconds", result);
    }


}
