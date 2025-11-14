package study.racing.domain;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_POSITION = 0;
    private final int value;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int value) {
        this.value = value;
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    public boolean isGreaterThan(int value) {
        return this.value > value;
    }

    public boolean isGreaterThan(Position other) {
        return isGreaterThan(other.value);
    }

    public boolean isEqualTo(int value) {
        return this.value == value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
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
