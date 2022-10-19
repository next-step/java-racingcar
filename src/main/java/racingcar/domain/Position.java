package racingcar.domain;

import java.util.Objects;

public class Position {

    private final int MOVE_POSITION = 1;
    private int position;

    public Position(final int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position += MOVE_POSITION;
    }

    public int comparePosition(int position) {
        if (position < this.position) {
            position = this.position;
        }
        return position;
    }

    public boolean hasMaxPosition(int position) {
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
        return Objects.hash(MOVE_POSITION, position);
    }
}
