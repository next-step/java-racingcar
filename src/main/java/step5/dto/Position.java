package step5.dto;

import step5.common.MyException;

import java.util.Objects;

public class Position {
    private static final int ZERO = 0;
    private static final int CALCULATE_UNIT = 1;
    private final int currentPosition;

    public Position() {
        this.currentPosition = ZERO;
    }

    public Position(int position) {
        validPosition(position);

        this.currentPosition = position;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Position plusPosition() {
        return new Position(this.currentPosition + CALCULATE_UNIT);
    }

    private void validPosition(int position) {
        if(ZERO > position) {
            throw new IllegalArgumentException(MyException.VALUE_GREATER_THAN_ZERO.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return currentPosition == position1.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition);
    }
}
