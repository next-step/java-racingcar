package step5.racingcar3.domain;

import java.util.Objects;
import step5.racingcar3.exception.PositionException;

public class Position implements Comparable<Position> {

    public static final int MIN_POSITION = 0;
    private int value;

    public Position() {
        this(MIN_POSITION);
    }

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    public void increase() {
        value++;
    }

    public int value() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN_POSITION) {
            throw new PositionException(String.format("위치는 %d 이상의 정수만 가능합니다.", MIN_POSITION));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position o) {
        Integer a = this.value;
        Integer b = o.value;
        return a.compareTo(b);
    }
}
