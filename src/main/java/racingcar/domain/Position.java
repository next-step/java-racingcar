package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final String POSITION_EXCEPTION_MESSAGE = "위치는 0 이상이어야 합니다.";

    private final int position;

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
        return position < 0;
    }

    public Position add(Position other) {
        return new Position(position + other.getPosition());
    }

    public int getPosition() {
        return position;
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
