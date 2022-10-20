package step3.domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 0보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public int position() {
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
