package racingcar.domain.moving;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int positon) {
        this.position = positon;
    }

    public static Position of(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("invalid position");
        }
        return new Position(position);
    }

    public int get() {
        return position;
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return Position.of(position + 1);
        }
        return this;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
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
