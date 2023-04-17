package refactoring.racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private final int value;

    public Position(int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        this.value = value;
    }

    public Position plus() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(value, o.value);
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
