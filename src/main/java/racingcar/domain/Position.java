package racingcar.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position 은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public Position() {
        this.position = 0;
    }

    public Position move() {
        position = position + 1;
        return this;
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
        return Integer.toString(position);
    }

    public boolean compare(Position compare) {
        return position >= compare.position ? true : false;
    }

    public int compareTo(Position compare) {
        return position > compare.position ? 1 : 0;
    }
}
