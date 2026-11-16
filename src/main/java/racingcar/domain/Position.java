package racingcar.domain;

import java.util.Objects;

public class Position {

    public static final int DEFAULT_INIT_POSITION = 0;
    private final int value;

    public Position() {
        this(DEFAULT_INIT_POSITION);
    }

    public Position(int position) {
        if (position < 0) {
            throw new RuntimeException("음수 위치에 존재 할 수 없습니다.");
        }
        this.value = position;
    }

    public Position move() {
        return new Position(value + 1);
    }


    public int getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}


