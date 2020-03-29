package study.racingcar.domain;

import java.util.Objects;

class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void add(int value) {
        this.position = this.position + value;
    }

    public Position clone() {
        return new Position(position);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override public int hashCode() {
        return Objects.hash(position);
    }
}
