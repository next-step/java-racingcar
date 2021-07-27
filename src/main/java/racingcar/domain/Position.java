package racingcar.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        checkIsNegative(position);
        this.position = position;
    }

    private void checkIsNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position 값은 0보다 작을 수 없습니다.");
        }
    }

    public Position move() {
        return new Position(position + 1);
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
