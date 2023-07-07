package racing.model;

import racing.exception.IllegalPositionException;

import java.util.Objects;

public final class Position {

    private static final int FIRST_VALUE = 1;
    private final int value;

    public Position() {
        this(FIRST_VALUE);
    }

    Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalPositionException();
        }
    }

    public Position goForward() {
        return new Position(this.value + 1);
    }

    public boolean isValue(int value) {
        return this.value == value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
