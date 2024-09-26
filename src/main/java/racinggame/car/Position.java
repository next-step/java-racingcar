package racinggame.car;

import java.util.Objects;


public class Position {

    private final int value;

    private static final int MINIMUM_VALUE = 0;

    public static Position of() {
        return new Position(MINIMUM_VALUE);
    }

    private Position(int value) {
        this.value = value;
    }

    public Position forward() {
        return new Position(value + 1);
    }

    public int value() {
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
        return Objects.hashCode(value);
    }
}
