package org.example.timeformatter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TimeFormatter {

    private Map<String, Integer> timeUnits = new LinkedHashMap<>();
    private List<String> formattedUnitsList = new ArrayList<>();

    private TimeFormatter() {
        timeUnits.put("year", 31536000);
        timeUnits.put("day", 86400);
        timeUnits.put("hour", 3600);
        timeUnits.put("minute", 60);
    }

    public static String formatDuration(int seconds) {
        TimeFormatter formatter = new TimeFormatter();

        return formatter.getFormattedDuration(seconds);
    }

    private String getFormattedDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        for (Map.Entry<String, Integer> entry : timeUnits.entrySet()) {
            if (seconds >= entry.getValue()) {
                appendFormattedUnit(getFormattedUnit(seconds / entry.getValue(), entry.getKey()));
                seconds %= entry.getValue();
            }
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
                resultBuilder.append(", ");
            } else if (i == listSize - 2) {
                resultBuilder.append(" and ");
            }
        }

        return resultBuilder.toString();
    }
}
