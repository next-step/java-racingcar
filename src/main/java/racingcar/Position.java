package racingcar;

import java.util.Objects;

public class Position {
    int position;

    public Position (int position) {
        this.position = position;
    }

    public Position (Position posToBeCopied) {
        this.position = posToBeCopied.position;
    }

    public Position increase() {
        position++;
        return new Position(position);
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
