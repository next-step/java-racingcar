package step5.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        position++;
        return this;
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.position, position.getPosition());
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
