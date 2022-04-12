package calculator;

import exception.NegativeException;

public class Positive {
    private int number;

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive(int number) {
        if (number < 0) {
            throw new NegativeException();
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
