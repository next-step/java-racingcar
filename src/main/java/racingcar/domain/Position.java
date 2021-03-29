package racingcar.domain;

import java.util.Objects;

import static racingcar.exception.Message.POSITION_VALUE_ERROR;

public class Position {

    public static final int DEFAULT = 0;

    private final int position;

    public Position() {
        this(DEFAULT);
    }

    public Position(int position) {
        if (position < DEFAULT) {
            throw new IllegalArgumentException(POSITION_VALUE_ERROR);
        }
        this.position = position;
    }

    public int position() {
        return position;
    }

    public Position increase() {
        return new Position(this.position + 1);
    }

    public Position max(Position other) {
        if (other.position > position) {
            return other;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
