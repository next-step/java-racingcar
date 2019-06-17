package camp.nextstep.edu.racingcar.domain;

import java.util.Objects;

public class Position {
    private static final Position ORIGIN = new Position(0);
    private static final int MINIMUM_VALUE = 0;

    private final int value;

    private Position(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("'value' must be greater than or equal to " + MINIMUM_VALUE);
        }
        this.value = value;
    }

    public static Position origin() {
        return ORIGIN;
    }

    public int getValue() {
        return value;
    }

    public Position add(int distance) {
        return new Position(this.value + distance);
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
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
