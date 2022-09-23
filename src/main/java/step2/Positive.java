package step2;

import java.util.Objects;
import step2.exception.InvalidStringException;
import step2.exception.NegativeNumberException;

public class Positive {

    private final int value;

    public Positive(String text) {
        this(toInt(text));
    }

    private static int toInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            throw new InvalidStringException();
        }
    }

    public Positive(int value) {
        if (value < 0) {
            throw new NegativeNumberException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Positive plus(Positive number) {
        return new Positive(this.value + number.value);
    }
}
