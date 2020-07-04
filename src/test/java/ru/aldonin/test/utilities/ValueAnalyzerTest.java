package ru.aldonin.test.utilities;

import org.junit.Test;
import ru.aldonin.test.exceptions.DifferentNumberTypesException;
import ru.aldonin.test.exceptions.InvalidInputFormatException;
import ru.aldonin.test.exceptions.InvalidOperatorException;

import static org.junit.Assert.*;

public class ValueAnalyzerTest {

    @Test
    public void convertInputToValues() throws InvalidInputFormatException {
        String input1 = "1 + 5";
        String input2 = "I - II";
        int[] actual1 = ValueAnalyzer.convertInputToValues(input1);
        int[] actual2 = ValueAnalyzer.convertInputToValues(input2);
        int[] expected1 = {1, '+', 5};
        int[] expected2 = {1, '-', 2};
        assertArrayEquals(expected1, actual1);
        assertArrayEquals(expected2, actual2);
    }

    @Test
    public void convertToInt() throws InvalidInputFormatException {
        String number = "IX";
        assertTrue(ValueAnalyzer.convertToInt(number) == 9);
    }

    @Test
    public void validateInput() {
        try {
            assertTrue(ValueAnalyzer.validateInput("I + IV"));
        } catch (DifferentNumberTypesException | InvalidInputFormatException | InvalidOperatorException e) {
            e.printStackTrace();
        }

    }
}