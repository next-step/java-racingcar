package step3.domains;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position에는 음수가 올 수 없습니다.");
        }

        this.position = position;
    }

    public Position incrementAndGet() {
        return new Position(position + 1);
    }

    public boolean isGreaterOrEquals(Position other) {
        return this.position >= other.position;
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
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
