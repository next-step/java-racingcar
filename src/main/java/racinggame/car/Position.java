package racinggame.car;

import java.util.Objects;


public class Position {

    private static final int MINIMUM_VALUE = 0;
    private static final int FORWARD_STEP = 1;

    private final int value;

    public Position () {
        this(MINIMUM_VALUE);
    }

    private Position(int value) {
        this.value = value;
    }

    public Position forward() {
        return new Position(value + FORWARD_STEP);
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
