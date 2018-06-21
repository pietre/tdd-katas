package org.example.timeformatter;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        String formatted = "";

        if (seconds == 1) {
            formatted += seconds + " second";
        }
        else {
            formatted += seconds + " seconds";
        }

        return formatted;
    }
}
