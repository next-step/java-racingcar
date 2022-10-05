package racing.domain.car;

import java.util.Objects;

public class Position {

    private final int positionValue;

    public Position(int positionValue) {
        if (positionValue < 0) {
            throw new IllegalArgumentException("위치값은 0 이상이어야 합니다");
        }
        this.positionValue = positionValue;
    }

    public Position move() {
        return new Position(this.positionValue + 1);
    }

    public boolean isBiggerThan(Position other) {
        return this.positionValue > other.positionValue;
    }

    public int getPositionValue() {
        return positionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return positionValue == position1.positionValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionValue);
    }
}
