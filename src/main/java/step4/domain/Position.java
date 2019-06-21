package step4.domain;

import java.util.Objects;

public class Position {
    static final int INITIAL_POSITION = 0;
    static final int DISTANCE_PER_MOVE = 1;
    static final int MOVE_CRITERION = 4;

    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public Position(int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException("위치값은 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public Position move(int randomNumber) {
        if (canMove(randomNumber)) {
            return new Position(position + DISTANCE_PER_MOVE);
        }
        return new Position(position);
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERION;
    }

    public int getPosition() {
        return position;
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
        return "Position{" +
                "position=" + position +
                '}';
    }
}
