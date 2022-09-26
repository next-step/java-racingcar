package calculator;

import exception.NegativeNumberException;

import java.util.Objects;

public class Positive {
    private final int number;
    private static final String INPUT_TEXT_IS_NOT_NUMBER = "Input text is not number.";

    public Positive(String value) {
        this(parseInt(value));
    }

    public Positive(int number) {
        if (number < 0) {
            throw new NegativeNumberException();
        }
        this.number = number;
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new NumberFormatException(INPUT_TEXT_IS_NOT_NUMBER);
        }
    }
    public Positive plus(int number) {
        return new Positive(this.number + number);
    }

    public Positive plus(Positive number) {
        return new Positive(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
