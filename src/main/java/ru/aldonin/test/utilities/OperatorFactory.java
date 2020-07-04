package ru.aldonin.test.utilities;

import ru.aldonin.test.enums.OperationSign;
import ru.aldonin.test.exceptions.InvalidOperatorException;
import ru.aldonin.test.executors.*;

public class OperatorFactory {

    public Operator getOperator(int[] input) throws InvalidOperatorException {
        if (input[1] == OperationSign.DIVISION.getSign())
            return new Divider(input[0], input[2]);
        if (input[1] == OperationSign.MULTIPLICATION.getSign())
            return new Multiplier(input[0], input[2]);
        if (input[1] == OperationSign.PLUS.getSign())
            return new Adder(input[0], input[2]);
        if (input[1] == OperationSign.MINUS.getSign())
            return new Subtractor(input[0], input[2]);
        else
            throw new InvalidOperatorException("Введён некорректный знак операции \"" + (char) input[1] + "\"");
    }
}
