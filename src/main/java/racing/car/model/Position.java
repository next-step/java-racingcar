package racing.car.model;

import java.util.Objects;

public class Position {
    private static final int MOVE_THRESHOLD = 4;
    private int position;

    public Position() {
    }

    public Position(int position) {
        this.position = position;
    }

    public Position increase(int number) {
        if (isMove(number)) {
            position++;
        }

        return new Position(position);
    }

    private boolean isMove(int number) {
        return number >= MOVE_THRESHOLD;
    }

    public int max(int maxPosition) {
        return Math.max(this.position, maxPosition);
    }

    public boolean isSame(int otherPosition) {
        return this.position == otherPosition;
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

    public int getPosition() {
        return this.position;
    }
}
