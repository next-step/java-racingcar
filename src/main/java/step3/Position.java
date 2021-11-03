package step3;

import java.util.Objects;

public class Position {
    private final Integer position;

    private Position(Integer position) {
        this.position = position;
    }

    public static Position create(Integer position) {
        return new Position(position);
    }

    public Position move() {
        return new Position(this.position + 1);
    }

    public String positionToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
