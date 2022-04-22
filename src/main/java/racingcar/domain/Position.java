package racingcar.domain;

import racingcar.domain.exception.PositionInvalidException;

import java.util.Objects;

public class Position {

    private static final int INITIAL_POSITION = 0;
    private static final int POSITION_INVALID_DIVISION_POINT = 0;

    private int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        if (position < POSITION_INVALID_DIVISION_POINT) {
            throw new PositionInvalidException();
        }
        this.position = position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public void up() {
        this.position++;
    }

    public int maxPosition(int maxPosition) {
        if (maxPosition < this.position) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isSameMoveDistance(int moveDistance) {
        return this.position == moveDistance;
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

    @Override
    public String toString() {
        return String.valueOf(this.position);
    }
}