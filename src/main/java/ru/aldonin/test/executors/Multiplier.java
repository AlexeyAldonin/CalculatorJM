package ru.aldonin.test.executors;

public class Multiplier extends Computer {

    public Multiplier(int n1, int n2) {
        super(n1, n2);
    }

    @Override
    public double compute() {
        return (double) this.n1 * this.n2;
    }
}
