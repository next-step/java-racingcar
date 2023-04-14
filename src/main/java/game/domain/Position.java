package game.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int value;

    public Position(int value) {
        validatePosition(value);
        this.value = value;
    }

    private void validatePosition(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Position 의 경우 0 이상의 수만 초기값 사용이 가능합니다.");
        }
    }

    public void forward() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public boolean isSame(Position position) {
        return position.equals(this);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(value, o.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}