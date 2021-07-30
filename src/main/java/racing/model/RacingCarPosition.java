package racing.model;

import java.util.Objects;

public class RacingCarPosition implements Comparable<RacingCarPosition> {
    private static final int ONE_SPACE = 1;

    private int position;

    void increaseOne() {
        position += ONE_SPACE;
    }

    int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCarPosition that = (RacingCarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(RacingCarPosition otherRacingCarPosition) {
        return position - otherRacingCarPosition.position;
    }
}
