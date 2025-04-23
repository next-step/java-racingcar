package step3;

import java.util.Objects;

public class Position {
    public static final int DEFAULT_POSITION = 1;
    private final int value;

    public Position() {
        this.value = DEFAULT_POSITION;
    }

    private Position(int value) {
        this.value = value;
    }

    public Position moveForward() {
        return new Position(this.value + 1);
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
