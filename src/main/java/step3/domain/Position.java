package step3.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void forward() {
        this.position++;
    }

    public int position() {
        return this.position;
    }

    public Position greaterPosition(Position position) {
        if(isGreaterThan(position)) {
            return this;
        }

        return position;
    }

    private boolean isGreaterThan(Position position) {
        return this.position > position.position();
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
