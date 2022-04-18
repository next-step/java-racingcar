package racing.domain;

import java.util.Objects;

public class Position {
    private int currentPosition;

    public Position() {
        currentPosition = 0;
    }

    public Position(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Position(Position position) {
        Objects.requireNonNull(position);
        currentPosition = position.getCurrentPosition();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void add(int runStep) {
        currentPosition = currentPosition + runStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return getCurrentPosition() == position.getCurrentPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrentPosition());
    }
}
