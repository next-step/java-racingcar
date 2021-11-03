package step3;

import java.util.Objects;

public class Position {

    private final Long position;

    public Position(Long position) {
        this.position = position;
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

    public Position move() {
        return new Position(this.position+1);
    }
}
