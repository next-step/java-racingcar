package calculator;

import java.util.Objects;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(String value) {
        this(Integer.parseInt(value));
    }

    public int getNumber() {
        return number;
    }

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        this.number = number;
    }

    public PositiveNumber plus(int number) {
        return new PositiveNumber(this.number + number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber positive = (PositiveNumber) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
