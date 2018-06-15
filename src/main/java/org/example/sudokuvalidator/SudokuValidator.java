package org.example.sudokuvalidator;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
    private static final int BOARD_SIZE = 9;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int UNIQUE_ELEMENTS_COUNT = 9;

    public static boolean check(int[][] board) {
        try {
            validateNumbersRange(board);
            validateRows(board);
            validateColumns(board);
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

    private static void validateRows(int[][] board) {
        Set<Integer> set;
        for (int[] row : board) {
            set = new HashSet<>();
            for (int number : row) {
                set.add(number);
            }
            if (set.size() != UNIQUE_ELEMENTS_COUNT) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateColumns(int[][] board) {
        Set<Integer> set;
        for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
            set = new HashSet<>();
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
                set.add(board[columnIndex][rowIndex]);
            }
            if (set.size() != UNIQUE_ELEMENTS_COUNT) {
                throw new IllegalArgumentException();
            }
        }
    }
}
