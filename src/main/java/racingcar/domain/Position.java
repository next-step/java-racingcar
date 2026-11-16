package racingcar.domain;

import java.util.Objects;

public final class Position {

    private static final int DEFAULT_INIT_POSITION = 0;
    private final int value;

    private Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("음수 위치에 존재 할 수 없습니다.");
        }
        this.value = position;
    }

    public static Position start() {
        return new Position(DEFAULT_INIT_POSITION);
    }

    public static Position of(int value) {
        return new Position(value);
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


