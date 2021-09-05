package stage4.domain;

import java.util.Objects;

public class Position {
    private static final int DEFAULT_VALUE = 0;
    private static final int ZERO_VALUE = 0;

    private int position;

    public Position(int position) {
        validateNegative(position);
        this.position = position;
    }

    public Position() {
        this(DEFAULT_VALUE);
    }

    public Position(Position position) {
        this(position.position);
    }

    private void validateNegative(int position) {
        if (position < ZERO_VALUE) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다");
        }
    }

    public int getPosition() {
        return this.position;
    }

    public void forward() {
        this.position++;
    }

    public boolean greaterThan(Position position) {
        return this.position > position.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
