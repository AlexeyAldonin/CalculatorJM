package ru.aldonin.test.utilities;

import ru.aldonin.test.enums.OperationSign;
import ru.aldonin.test.enums.RomanNumber;
import ru.aldonin.test.exceptions.DifferentNumberTypesException;
import ru.aldonin.test.exceptions.InvalidInputFormatException;
import ru.aldonin.test.exceptions.InvalidOperatorException;

public class ValueAnalyzer {

    public static int[] convertInputToValues(String input) throws InvalidInputFormatException {
        String[] symbols = input.split(" ");
        int[] out = new int[symbols.length];
        out[0] = convertToInt(symbols[0]);
        out[1] = symbols[1].charAt(0);
        out[2] = convertToInt(symbols[2]);
        return out;
    }

     public static int convertToInt(String input) throws InvalidInputFormatException {
         if (stringIsRomanNumber(input))
             return RomanNumber.valueOf(input).getValue();
         try {
             return Integer.parseInt(input);
         } catch (Exception e) {
             throw new InvalidInputFormatException("Введённые аргументы не являются числами");
         }
     }

     public static void printNumber(double number) {
         if (number % 1 == 0) {
             System.out.println((int) number);
         }
         else System.out.println(number);
     }

     public static boolean validateInput(String input) throws DifferentNumberTypesException, InvalidOperatorException, InvalidInputFormatException {
         String[] symbols = input.split(" ");
         if (symbols.length != 3) {
             throw new InvalidInputFormatException("Введённые данные не соответсвуют требуемому формату");
         }
         if (!numbersAreSameType(symbols[0], symbols[2])) {
             throw new DifferentNumberTypesException("Введённые числа разного формата");
         }
         if (!symbolIsMathSign(symbols[1])) {
             throw new InvalidOperatorException("Введён некорректный знак операции \"" + symbols[2] + "\"");
         }
         if (validateNumberRange(convertToInt(symbols[0])) || validateNumberRange(convertToInt(symbols[2]))) {
             throw new InvalidInputFormatException("Введённые числа вне допустимого диапазона");
         }
         return true;
     }

     public static boolean stringIsRomanNumber(String input) {
         for (RomanNumber number : RomanNumber.values()) {
             if (input.equalsIgnoreCase(number.name())) {
                 return true;
             }
         }
         return false;
     }

    private static boolean numbersAreSameType(String s1, String s2) {
         return (stringIsRomanNumber(s1) && stringIsRomanNumber(s2)) ||
                 (!stringIsRomanNumber(s1) && !stringIsRomanNumber(s2));
     }

    private static boolean symbolIsMathSign(String symbol) {
         for (OperationSign sign : OperationSign.values()) {
             if (symbol.equalsIgnoreCase(String.valueOf(sign.getSign()))) {
                 return true;
             }
         }
         return false;
     }

    private static boolean validateNumberRange (int n) {
         return n < 1 || n > 10;
     }
}
