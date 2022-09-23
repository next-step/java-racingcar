package racingcar.domain;

import java.util.Objects;

 public class Position {
    private static final String POSITION_EXCEPTION_MESSAGE = "위치는 1 이상이어야 합니다.";
    private static final int DEFAULT_POSITION = 1;

    private final int value;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int value) {
        validate(value);

        this.value = value;
    }

    private void validate(int position) {
        if (isNegative(position)) {
            throw new IllegalArgumentException(POSITION_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNegative(int position) {
        return position < DEFAULT_POSITION;
    }

    public Position add(int position) {
        return new Position(this.value + position);
    }

    public Position add(Position other) {
        return new Position(value + other.getValue());
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

        Position other = (Position) o;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
