package carracing.domain;

import java.util.Objects;

public class Position {
    public static final int DEFAULT_POSITION = 0;
    private final int value;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Position move() {
        return new Position(value + 1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Position position = (Position) object;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
