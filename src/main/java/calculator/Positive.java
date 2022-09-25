package calculator;

import java.util.Objects;

public class Positive {
    private final int number;
    public Positive(String value) {
        this.number = Integer.parseInt(value);
    }

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public Positive plus(int number) {
        return new Positive(this.number + number);
    }

    public Positive plus(Positive number) {
        return new Positive(this.number + number.number);
    }

    public int getNumber() {
        return number;
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
