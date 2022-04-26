package racingcar;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_POSITION = 0;
    private final int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException("position must be at least 0");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
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

    public Position maxPosition(Position maxPosition) {
        if (this.position > maxPosition.position) {
            return this;
        }
        return maxPosition;
    }

    public boolean isMaxPosition(Position maxPosition) {
        return this == maxPosition;
    }
}
