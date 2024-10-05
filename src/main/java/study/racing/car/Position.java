package study.racing.car;

import java.util.Objects;

public class Position {

    private int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수를 허용하지 않습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Position increase() {
        this.value++;
        return this;
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
        return Objects.hashCode(value);
    }
}
