package racing.example;

import java.util.Objects;

public class Position {
    private final int position;

    public Position() {
        this(0);
    }

    public Position(Position position) {
        this(position.position + 1);
    }

    public Position(String position) {
        this(Integer.parseInt(position));
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("이동거리는 음수가 될 수 없습니다.");
        }
        this.position = position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return Objects.equals(this.position, maxPosition);
    }

    public int maxPosition(int maxPosition) {
        return Math.max(maxPosition, this.position);
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
