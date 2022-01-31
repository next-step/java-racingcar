package racing.domain.car;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public Position(Position position) {
        this(position.getValue());
    }

    public Position move() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
