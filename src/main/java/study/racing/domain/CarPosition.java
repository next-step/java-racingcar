package study.racing.domain;

import java.util.Objects;

public class CarPosition {
    private static final int DEFAULT_POSITION = 0;
    private final int value;

    public CarPosition() {
        this(DEFAULT_POSITION);
    }

    public CarPosition(int value) {
        this.value = value;
    }

    public CarPosition increase() {
        return new CarPosition(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CarPosition{value= " + value + " }";
    }
}
