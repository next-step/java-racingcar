package racing.domain.car;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치값은 0 이상이어야 합니다");
        }
        this.value = value;
    }

    public Position move() {
        return new Position(this.value + 1);
    }

    public boolean isBiggerThan(Position other) {
        return this.value > other.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
