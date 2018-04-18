package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SPLIT_PATTERN = ",|\n";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int add(final String numbers) {
        String numbersString = numbers;
        String splitPattern = DEFAULT_SPLIT_PATTERN;
        if (numbersString.isEmpty()) {
            return 0;
        }

        Pattern r = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
        Matcher m = r.matcher(numbersString);
        if (m.find()) {
            splitPattern += "|" + m.group(1);
            numbersString = m.group(2);
        }
        
        int sum = 0;
        for (String number : numbersString.split(splitPattern)) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

}
