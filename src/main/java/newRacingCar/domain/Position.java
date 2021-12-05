package newRacingCar.domain;

import java.util.Objects;

public class Position {
    private int position;

    Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("차는 0 이상 움직여야 합니다.");
        }
        this.position = position;
    }

    public Position move() {
        this.position += 1;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Position findMaxPosition(Position position) {
        Position maxPosition = this;
        if (this.position < position.getPosition()) {
            maxPosition = position;
        }
        return maxPosition;
    }

    public boolean isSamePosition(Position position) {
        return this.equals(position);
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
