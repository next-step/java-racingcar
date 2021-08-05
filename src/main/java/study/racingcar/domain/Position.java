package study.racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int START_POSITION = 0;

    private int position;

    public Position(int position) {
        if (position < START_POSITION) {
            throw new IllegalArgumentException("0 이하로는 움직일 수 없습니다");
        }
        this.position = position;
    }

    public Position moveForward() {
        return new Position(++position);
    }

    public int getValue() {
        return this.position;
    }

    public Position() {
        this.position = START_POSITION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
