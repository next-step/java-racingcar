package racingcar;

import java.util.Objects;

public class Positive {

    private final int value;

    public Positive(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value <= 0) {
            throw new NotPositiveNumberException();
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return value == positive.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
