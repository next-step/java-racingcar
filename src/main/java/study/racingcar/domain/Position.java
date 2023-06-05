package study.racingcar.domain;

import java.util.Objects;

public class Position{
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
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
        return String.valueOf(position);
    }

    public boolean isSame(int maxPosition) {
        return position == maxPosition;
    }
}