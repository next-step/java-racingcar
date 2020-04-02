package study.racingcar.domain;

import java.util.Objects;

class Position {
    public static final int ZERO = 0;
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public Position(Position position) {
        this.position = position.position;
    }

    public int getPosition() {
        return position;
    }

    public void add(int value) {
        this.position = this.position + value;
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
