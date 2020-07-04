package ru.aldonin.test.executors;

public abstract class Computer implements Operator {

    int n1;
    int n2;

    public Computer(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}
