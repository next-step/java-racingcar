package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int INITIAL_POSITION = 0;

    private int position;

    public Position() {
        this(INITIAL_POSITION);
    }

    public Position(int position) {
        if (position < 0) {
            throw new RuntimeException();
        }
        this.position = position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public void up() {
        this.position++;
    }

    public int maxPosition(int maxPosition) {
        if (maxPosition < this.position) {
            return this.position;
        }
        return maxPosition;
    }

    public int get() {
        return this.position;
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