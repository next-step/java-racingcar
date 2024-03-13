package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final int DEFAULT_STEP_COUNT = 0;

    private final int step;

    public Position() {
        this.step = DEFAULT_STEP_COUNT;
    }

    public Position(int step) {
        this.step = step;
    }

    public Position moveOneStep() {
        return new Position(step + 1);
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
        return step == position1.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DEFAULT_STEP_COUNT, step);
    }

}
