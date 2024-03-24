package racingcar.domain;

import java.util.Objects;

public final class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("0보다 작은 값이 될 수 없습니다.");
        }
        this.position = position;
    }

    public int get() {
        return position;
    }

    public int max(int other) {
        if (this.position > other) {
            return this.position;
        }
        return other;
    }

    public void updatePosition(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    public boolean isMatch(int maxPosition) {
        return maxPosition == this.position;
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
