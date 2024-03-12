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

    public Position move() {
        this.position += 1;
        return new Position(this.position);
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Position other) {
        return other.position - this.position;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Position position1 = (Position) other;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
