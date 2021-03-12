package racing.model;

import java.util.Objects;

public class Position {

    private int position;
    private static final int ZERO = 0;
    private static final String POSITION = "-";

    public Position(int position) {
        valid(position);
        this.position = position;
    }

    public Position getPosition() {
        return this;
    }

    /**
     * 자동차 위치를 이동시켜주는 메서드
     */
    public void move() {
        position = position + 1;
    }

    public void valid(int position) {
        if (position < ZERO) {
            throw new IllegalArgumentException("포지션은 음수일 수 없습니다.");
        }
    }

    public boolean isSame(Position position) {
        return this.position == position.position;
    }

    public String moveDistance() {
        return POSITION.repeat(position);
    }

    public boolean isGreaterThan(Position otherCarPosition) {
        return this.position > otherCarPosition.position;
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
}
