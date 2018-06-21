package org.example.timeformatter;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    private static final int SECONDS_PER_MINUTE = 60;
    private List<String> formattedUnitsList = new ArrayList<>();

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        TimeFormatter formatter = new TimeFormatter();

        return formatter.getFormattedDuration(seconds);
    }

    private String getFormattedDuration(int seconds) {
        if (seconds >= SECONDS_PER_MINUTE) {
            int minutes = seconds / SECONDS_PER_MINUTE;
            seconds %= SECONDS_PER_MINUTE;
            appendFormattedUnit(getFormattedUnit(minutes, "minute"));
        }
        appendFormattedUnit(getFormattedUnit(seconds, "second"));

        return joinFormattedUnitsList();
    }

    private String getFormattedUnit(int value, String singleUnitName) {
        if (value == 0) {
            return "";
        } else if (value == 1) {
            return value + " " + singleUnitName;
        }
        return value + " " + singleUnitName + "s";
    }

    private void appendFormattedUnit(String formattedUnit) {
        if (!formattedUnit.isEmpty()) {
            formattedUnitsList.add(formattedUnit);
        }
    }

    private String joinFormattedUnitsList() {
        StringBuilder resultBuilder = new StringBuilder();
        int listSize = formattedUnitsList.size();
        for (int i = 0; i < listSize; i++) {
            resultBuilder.append(formattedUnitsList.get(i));
            if (i < listSize - 2) {
                resultBuilder.append(" , ");
            } else if (i == listSize - 2) {
                resultBuilder.append(" and ");
            }
        }

        return resultBuilder.toString();
    }
}
