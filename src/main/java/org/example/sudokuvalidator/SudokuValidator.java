package org.example.sudokuvalidator;

public class SudokuValidator {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static boolean check(int[][] board) {
        try {
            validateNumbersRange(board);
        } catch (IllegalArgumentException ex) {
            return false;
        }

        return true;
    }

    private static void validateNumbersRange(int[][] board) {
        for (int[] row : board) {
            for (int number : row) {
                if (!isWithinAllowedRange(number)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private static boolean isWithinAllowedRange(int number) {
        return number >= MIN_VALUE && number <= MAX_VALUE;
    }

}
