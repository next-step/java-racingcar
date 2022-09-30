package calculator;

import java.util.Objects;

public class Positive {
    private final int number;

    public Positive(final String value) {
        this(Integer.parseInt(value));
    }

    public Positive(final int number) {
        if(number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        this.number = number;
    }

    public Positive plus(final int number) {
        return new Positive(this.number + number);
    }

    public Positive plus(final Positive positive) {
        return new Positive(this.number + positive.number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Positive{ number=" + number + "}";
    }
}
