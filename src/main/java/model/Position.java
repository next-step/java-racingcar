package model;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("음수 값은 불가합니다");
        }

        this.position = position;
    }

    public void move() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Position o) {
        return o.position - this.position;
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
