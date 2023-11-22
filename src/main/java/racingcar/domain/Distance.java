package racingcar.domain;

import java.util.Objects;

public class Distance {

    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public boolean matchDistance(int distance) {
        return this.distance == distance;
    }

    public int max(int maxDistance) {
        if (this.distance > maxDistance) {
            return this.distance;
        }

        return maxDistance;
    }

    void plus() {
        this.distance++;
    }

    public int distance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }
}
