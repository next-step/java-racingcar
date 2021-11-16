package racingcar.domain;

import java.util.Objects;

public class Distance implements Comparable<Distance> {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void increment() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Distance that = (Distance) object;

        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public int compareTo(Distance distance) {
        return Integer.compare(this.distance, distance.distance);
    }
}
