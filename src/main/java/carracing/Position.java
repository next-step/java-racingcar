package carracing;

import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("0 또는 양수를 입력해주세요.");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public boolean isBiggerThan(Position other) {
        return this.position > other.position;
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
}
