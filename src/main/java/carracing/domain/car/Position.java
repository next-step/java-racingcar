package carracing.domain.car;

import carracing.exception.RacingCarIllegalArgumentException;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_POSITION = 1;
    private static final int DEFAULT_INCREMENT = 1;

    private final int value;

    private Position(int value) {
        if (value < 0) {
            throw RacingCarIllegalArgumentException.INVALID_POSITION;
        }
        this.value = value;
    }

    public static Position from(int value) {
        return new Position(value);
    }

    public static Position create() {
        return new Position(DEFAULT_POSITION);
    }

    public int increase() {
        return this.value + DEFAULT_INCREMENT;
    }

    public Position createMaxPosition(Position otherPosition) {
        int maxPosition = Math.max(this.value, otherPosition.value);
        return Position.from(maxPosition);
    }

    public boolean isSame(Position otherPosition) {
        return this.value == otherPosition.getValue();
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
        return Objects.hashCode(value);
    }
}
