package racinggame.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int MIN_POSITION = 0;
    private static final String GREATER_THAN_ZERO = "0 이상의 숫자만 가능 합니다.";

    private final int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(GREATER_THAN_ZERO);
        }
    }

    public Position move() {
        return new Position(this.position + 1);
    }

    public int getPosition() {
        return position;
    }

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

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }
}
