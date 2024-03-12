package racinggame.domain;

import java.util.Objects;

public class Position {
    public static final String NEGATIVE_LOCATION_MESSAGE = "위치가 음수가 될 수 없습니다.";
    public static final int MIN_POSITION_VALUE = 0;
    public static final int FORWARD_COUNT = 1;

    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        validateHandleNegative(position);
        this.position = position;
    }

    private void validateHandleNegative(int position) {
        if (position < MIN_POSITION_VALUE) {
            throw new IllegalArgumentException(NEGATIVE_LOCATION_MESSAGE);
        }
    }

    public Position move() {
        return new Position(position + FORWARD_COUNT);
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
