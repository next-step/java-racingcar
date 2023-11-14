package car;

import java.util.Objects;

public class CarPosition implements Comparable<CarPosition> {

    private static final int MIN_DISTANCE = 0;
    private final int distance;

    public CarPosition(int distance) {
        validateMoreThanMinDistance(distance);
        this.distance = distance;
    }

    private void validateMoreThanMinDistance(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("distance는 항상 0 이상이어야 합니다.");
        }
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(CarPosition otherCarPosition) {
        return this.distance - otherCarPosition.distance;
    }

    public boolean isSameDistance(CarPosition winnerCarPosition) {
        return this.distance == winnerCarPosition.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
