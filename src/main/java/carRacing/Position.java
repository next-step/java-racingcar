package carRacing;

import java.util.Objects;

public class Position {
    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
        this.value = value;
    }

    public int value() {
        return value;
    }

    public void plus() {
        value++;
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
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

    public boolean isGreaterThan(Position other) {
        return value >= other.value;
    }
}
