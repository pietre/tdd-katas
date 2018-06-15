package org.example;

import org.example.sudokuvalidator.SudokuValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class SudokuValidatorTest {

    private final int[][] validBoard = {
            {5, 3, 4,   6, 7, 8,   9, 1, 2},
            {6, 7, 2,   1, 9, 5,   3, 4, 8},
            {1, 9, 8,   3, 4, 2,   5, 6, 7},

            {8, 5, 9,   7, 6, 1,   4, 2, 3},
            {4, 2, 6,   8, 5, 3,   7, 9, 1},
            {7, 1, 3,   9, 2, 4,   8, 5, 6},

            {9, 6, 1,   5, 3, 7,   2, 8, 4},
            {2, 8, 7,   4, 1, 9,   6, 3, 5},
            {3, 4, 5,   2, 8, 6,   1, 7, 9}
    };

    private final int[][] invalidBlocksBoard = {
            {1, 2, 3,   4, 5, 6,   7, 8, 9},
            {2, 3, 4,   5, 6, 7,   8, 9, 1},
            {3, 4, 5,   6, 7, 8,   9, 1, 2},

            {4, 5, 6,   7, 8, 9,   1, 2, 3},
            {5, 6, 7,   8, 9, 1,   2, 3, 4},
            {6, 7, 8,   9, 1, 2,   3, 4, 5},

            {7, 8, 9,   1, 2, 3,   4, 5, 6},
            {8, 9, 1,   2, 3, 4,   5, 6, 7},
            {9, 1, 2,   3, 4, 5,   6, 7, 8},
    };

    @Test
    public void returnsTrueForValidBoard() {
        int[][] sudokuBoard = validBoard;

        SudokuValidator.checkWithExceptions(sudokuBoard);
    }

    @Test
    public void returnsFalseForNumbersOutOfAllowedRange() {
        int[][] sudokuBoard = validBoard;
        sudokuBoard[3][3] = 10;

        try {
            SudokuValidator.checkWithExceptions(sudokuBoard);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex) {
            assertEquals("range", ex.getMessage());
        }
    }

    @Test
    public void returnsFalseForRowsContainingDuplicates() {
        int[][] sudokuBoard = validBoard;
        sudokuBoard[0][1] = 5;

        try {
            SudokuValidator.checkWithExceptions(sudokuBoard);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex) {
            assertEquals("rows", ex.getMessage());
        }
    }

    @Test
    public void returnsFalseForColumnsContainingDuplicates() {
        int[][] sudokuBoard = validBoard;
        sudokuBoard[0][0] = 3;
        sudokuBoard[0][1] = 5;

        try {
            SudokuValidator.checkWithExceptions(sudokuBoard);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex) {
            assertEquals("columns", ex.getMessage());
        }
    }

    @Test
    public void returnsFalseForBlocksContainingDuplicates() {
        int[][] sudokuBoard = invalidBlocksBoard;

        try {
            SudokuValidator.checkWithExceptions(sudokuBoard);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException ex) {
            assertEquals("blocks", ex.getMessage());
        }
    }
}
