package calculator;

import java.util.Objects;

public class PositiveNumber {
    private final int number;
    public PositiveNumber(String value) {
        this.number = Integer.parseInt(value);
    }

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

    public PositiveNumber plus(int number) {
        return new PositiveNumber(this.number + number);
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }

    public int getNumber() {
        return number;
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
