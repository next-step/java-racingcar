package racingcar.domain;

import java.util.Comparator;
import java.util.Objects;

public class Position implements Comparator {
    private static final String POSITION_EXCEPTION_MESSAGE = "위치는 1 이상이어야 합니다.";
    private static final int DEFAULT_POSITION = 1;

    private final int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        validate(position);

        this.position = position;
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
        return new Position(this.position + position);
    }

    public Position add(Position other) {
        return new Position(position + other.getPosition());
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return ((Position) o1).position - ((Position) o2).position;
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
