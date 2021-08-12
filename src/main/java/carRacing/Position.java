package carRacing;


import java.util.Objects;

public class Position {
    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("포지션 값이 음수입니다.");
        }

        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public Position max(Position maxPosition) {
        if (maxPosition.position < position) {
            return this;
        }
        return maxPosition;
    }

    public String toStringPosition() {
        StringBuilder state = new StringBuilder();

        for (int i = 0; i < position; i++) {
            state.append("-");
        }

        return state.toString();
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
