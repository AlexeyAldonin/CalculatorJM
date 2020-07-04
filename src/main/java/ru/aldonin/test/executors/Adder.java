package ru.aldonin.test.executors;

public class Adder extends Computer {

    public Adder(int n1, int n2) {
        super(n1, n2);
    }

    @Override
    public double compute() {
        return (double) this.n1 + this.n2;
    }
}
