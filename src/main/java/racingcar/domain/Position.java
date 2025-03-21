package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int value;

    private Position(int initPosition) {
        this.value = initPosition;
    }

    public static Position of(int initPosition) {
        if (initPosition < 0) {
            throw new IllegalArgumentException("위치는 0 이상의 정수만 가능합니다.");
        }
        return new Position(initPosition);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.value, o.value);
    }

    public Position plus() {
        return new Position(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
