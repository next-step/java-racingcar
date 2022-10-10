package domain.calculator.dto;

import java.util.Objects;

public class Positive {
    private final int number;

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수값은 허용되지 않습니다.");
        }

        this.number = number;
    }

    public int plus(int number) {
        return this.number + number;
    }

    public Positive plus(Positive positive) {
        return new Positive(this.number + positive.number);
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