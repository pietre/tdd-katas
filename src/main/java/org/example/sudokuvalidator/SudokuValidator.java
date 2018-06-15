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
            return checkWithExceptions(board);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public static boolean checkWithExceptions(int[][] board) {
        validateNumbersRange(board);
        validateRows(board);
        validateColumns(board);
        validateBlocks(board);

        return true;
    }

    private static void validateNumbersRange(int[][] board) {
        for (int[] row : board) {
            for (int number : row) {
                if (!isWithinAllowedRange(number)) {
                    throw new IllegalArgumentException("range");
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
                throw new IllegalArgumentException("rows");
            }
        }
    }

    private static void validateColumns(int[][] board) {
        Set<Integer> set;
        for (int columnIndex = 0; columnIndex < BOARD_SIZE; columnIndex++) {
            set = new HashSet<>();
            for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
                set.add(board[rowIndex][columnIndex]);
            }
            if (set.size() != UNIQUE_ELEMENTS_COUNT) {
                throw new IllegalArgumentException("columns");
            }
        }
    }

    private static void validateBlocks(int[][] board) {
        Set<Integer> set;
        for (int rowPosition = 0; rowPosition < 3; rowPosition++) {
            for (int columnPosition = 0; columnPosition < 3; columnPosition++) {
                set = new HashSet<>();
                for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
                    for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
                        set.add(board[3*rowPosition + rowIndex][3*columnPosition + columnIndex]);
                    }
                }
                if (set.size() != UNIQUE_ELEMENTS_COUNT) {
                    throw new IllegalArgumentException("blocks");
                }
            }
        }
    }
}
