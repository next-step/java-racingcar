package step4.domain.car.position;

import java.util.Objects;

public final class Position {
    private int position;

    public Position() {
        this(0);
    }

    public Position(int position) {
        if(isLessThanZero(position)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.position = position;
    }

    private final boolean isLessThanZero(int position) {
        return position < 0;
    }

    public final void increase() {
        position++;
    }

    public final Position getWinningPosition(Position other) {
        return this.position > other.position ? this : other;
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
