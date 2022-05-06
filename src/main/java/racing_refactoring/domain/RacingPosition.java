package racing_refactoring.domain;

import java.util.Objects;

public class RacingPosition {
    private static final int MOVE = 1;
    private static final int NOT_MOVE = 0;

    private final int position;

    RacingPosition(int position) {
        this.position = position;
    }

    RacingPosition move(MovingStrategy movingStrategy) {
        return new RacingPosition(this.position + increase(movingStrategy));
    }

    private int increase(MovingStrategy movingStrategy) {
        if (movingStrategy.checkCondition()) {
            return MOVE;
        }
        return NOT_MOVE;
    }

    boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    int maxPosition(int maxPosition) {
        return Math.max(this.position, maxPosition);
    }

    int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingPosition that = (RacingPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "RacingPosition{" +
                "position=" + position +
                '}';
    }
}
