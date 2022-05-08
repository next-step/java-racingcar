package racing_refactoring.domain;

import java.util.Objects;

public class RacingPosition {
    private int position;

    RacingPosition(int position) {
        this.position = position;
    }

    RacingPosition move() {
        return new RacingPosition(this.position + 1);
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
