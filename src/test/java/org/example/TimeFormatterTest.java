package org.example;

import org.example.timeformatter.TimeFormatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void returnsMinuteWithSeconds() {
        int seconds = 70;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("1 minute and 10 seconds", result);
    }

    @Test
    public void returnsManyMinutes() {
        int seconds = 120;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("2 minutes", result);
    }

    @Test
    public void returnsHour() {
        int seconds = 3600;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("1 hour", result);
    }


    @Test
    public void returnsHourMinutesAndSeconds() {
        int seconds = 3662;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("1 hour, 1 minute and 2 seconds", result);
    }


    @Test
    public void returnsDaysHourMinutesAndSeconds() {
        int seconds = 313713;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("3 days, 15 hours, 8 minutes and 33 seconds", result);
    }

    @Test
    public void returnsYears() {
        int seconds = 94608000;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("3 years", result);
    }

    @Test
    public void returnsYearsDaysHourMinutesAndSeconds() {
        int seconds = 199043275;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("6 years, 113 days, 17 hours, 47 minutes and 55 seconds", result);
    }

    @Test
    public void returnsNowOnZeroSeconds() {
        int seconds = 0;

        String result = TimeFormatter.formatDuration(seconds);

        assertEquals("now", result);
    }
}
