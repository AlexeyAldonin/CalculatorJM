package ru.aldonin.test.app;

import ru.aldonin.test.exceptions.DifferentNumberTypesException;
import ru.aldonin.test.exceptions.InvalidInputFormatException;
import ru.aldonin.test.exceptions.InvalidOperatorException;
import ru.aldonin.test.executors.Operator;
import ru.aldonin.test.utilities.Announcer;
import ru.aldonin.test.utilities.NumbersConverter;
import ru.aldonin.test.utilities.OperatorFactory;
import ru.aldonin.test.utilities.ValueAnalyzer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Announcer.sayHello();

        String input = new Scanner(System.in).nextLine();

        try {
            if (ValueAnalyzer.validateInput(input)) {
                OperatorFactory factory = new OperatorFactory();
                Operator operator = factory.getOperator(ValueAnalyzer.convertInputToValues(input));
                Announcer.declareResult();
                if (ValueAnalyzer.stringIsRomanNumber(input.split(" ")[0])) {
                    NumbersConverter.printRomanValue((int) operator.compute());
                } else {
                    ValueAnalyzer.printNumber(operator.compute());
                }
            }
        } catch (DifferentNumberTypesException | InvalidOperatorException | InvalidInputFormatException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Announcer.sayBye();
        }
    }
}
