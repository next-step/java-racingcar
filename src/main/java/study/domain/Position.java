package study.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("음수의 포지션은 가질 수 없습니다.");
        }
    }

    public void move() {
        position = position + 1;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSame(int position) {
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
