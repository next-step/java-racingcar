package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private final int position;

    //==생성 메서드==//
    public Position() {
        this(DEFAULT_POSITION);
    }

    private Position(int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException("position must be at least 0");
        }
        this.position = position;
    }

    //==비즈니스 로직==//
    public Position move() {
        return new Position(position + 1);
    }


    //==getter==//
    public int getPosition() {
        return position;
    }

    //=공통 메서드==//
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
