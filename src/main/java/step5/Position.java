package step5;

import java.util.Objects;

public class Position {
    private final int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new RuntimeException("위치 값은 음수일 수 없다.");
        }
    }

    int getPosition() {
        return this.position;
    }

    public Position move() {
        return new Position(this.position + 1);
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
        return Objects.hashCode(position);
    }
}
