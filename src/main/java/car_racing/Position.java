package car_racing;

import java.util.Objects;

public class Position {
    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return this.position;
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

    public Position move() {
        return new Position(position + 1);
    }

    public boolean lessThan(Position maxPosition) {
        return this.position < maxPosition.getPosition();
    }
}
