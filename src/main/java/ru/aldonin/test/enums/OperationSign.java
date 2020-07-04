package ru.aldonin.test.enums;

public enum OperationSign {

    PLUS ('+'),
    MINUS ('-'),
    MULTIPLICATION ('*'),
    DIVISION ('/')
    ;

    private char sign;

    OperationSign(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
