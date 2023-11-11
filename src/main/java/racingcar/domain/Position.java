package racingcar.domain;

import java.util.Objects;

public class Position {
    private int number;

    public Position() {
        this(0);
    }

    public Position(final int number) {
        if (number < 0) throw new IllegalArgumentException("음수 값은 입력할 수 없습니다");
        this.number = number;
    }

    public void move() {
        ++number;
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return number == position.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
