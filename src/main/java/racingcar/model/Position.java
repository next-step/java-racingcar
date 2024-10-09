package racingcar.model;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int currentPosition() {
        return position;
    }

    public int max(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }

        return maxPosition;
    }

    public boolean hasSamePosition(int position) {
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
