package domain;

import java.util.Objects;

public class Position {

    private int currentPosition;

    public Position(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position move() {
        return new Position(this.currentPosition + 1);
    }

    public int currentPosition() {
        return currentPosition;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return currentPosition == that.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition);
    }

}
