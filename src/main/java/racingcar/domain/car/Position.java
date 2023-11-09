package racingcar.domain.car;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_MOVE_POSITION = 1;
    private int position;

    public Position() {
    }

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    public Position move() {
        return new Position(this.position + DEFAULT_MOVE_POSITION);
    }

    public int getPosition() {
        return position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션은 음수값을 가질 수 없습니다.");
        }
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
