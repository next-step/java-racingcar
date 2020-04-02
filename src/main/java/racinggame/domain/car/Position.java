package racinggame.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int MOVEABLE_POSITION = 1;
    /**
     * Cars-getMaxMoveRange()에서 상수를 불러오다 보니 public으로 선언 되었습니다
     */
    public static final int ZERO = 0;
    private static final String GREATER_THAN_ZERO = "0 이상의 숫자만 가능 합니다.";

    private final int position;

    public Position() {
        this(ZERO);
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < ZERO) {
            throw new IllegalArgumentException(GREATER_THAN_ZERO);
        }
    }

    public Position move() {
        return new Position(this.position + MOVEABLE_POSITION);
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
