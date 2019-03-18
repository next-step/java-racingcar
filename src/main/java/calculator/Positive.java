package calculator;

import java.util.Objects;

public class Positive {
    private final int number;

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public Positive add(Positive positive) {
        return new Positive(this.number + positive.number);
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
