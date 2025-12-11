package step5.racing.domain;

import java.util.Objects;

public class Position {

    private static final String INVALID_POSITION_MESSAGE = "위치는 양수여야 합니다.";
    private static final int INITIAL_POSITION = 0;

    private final int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION_MESSAGE);
        }
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int value() {
        return this.position;
    }

    public Position biggerPosition(Position other) {
        if (isGreaterThan(other)) {
            return this;
        }
        return other;
    }

    public boolean isGreaterThan(Position other) {
        return this.position > other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position other = (Position) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
