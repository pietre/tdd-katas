package org.example.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SPLIT_PATTERN = ",|\n";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.+)\n(.*)";

    private static final int CUSTOM_DELIMITER_CAPTURED_GROUP_INDEX = 1;
    private static final int NUMBERS_CAPTURED_GROUP_INDEX = 2;

    public static int add(final String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        return calculateSum(numbers);
    }

    private static int calculateSum(final String numbers) {
        String numbersString = numbers;
        String splitPattern = DEFAULT_SPLIT_PATTERN;

        Matcher matcher = getCustomDelimiterMatcher(numbersString);
        if (matcher.find()) {
            splitPattern += appendCustomDelimiter(matcher);
            numbersString = getNumbersWithoutCustomDelimiter(numbersString);
        }

        return addNumbersSplitByPattern(numbersString, splitPattern);
    }

    private static Matcher getCustomDelimiterMatcher(String numbersString) {
        Pattern r = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

        return r.matcher(numbersString);
    }

    private static String getNumbersWithoutCustomDelimiter(String numbersString) {
        return numbersString.substring((numbersString.indexOf("\n") + 1));
    }

    private static String appendCustomDelimiter(Matcher matcher) {
        return "|" + matcher.group(CUSTOM_DELIMITER_CAPTURED_GROUP_INDEX);
    }

    private static int addNumbersSplitByPattern(String numbersString, String splitPattern) {
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numbersString.split(splitPattern)) {
            if (number.matches("-\\d+")) {
                negativeNumbers.add(number);
            }
            sum += Integer.parseInt(number);
        }

        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumberException(negativeNumbers);
        }

        return sum;
    }

}
