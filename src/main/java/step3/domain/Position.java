package step3.domain;

import java.util.Objects;

public class Position {
    public static final int DEFAULT_POSITION = 1;

    private int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public void proceed() {
        ++position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return this.position;
    }
}
