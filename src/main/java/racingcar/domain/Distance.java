package racingcar.domain;

import java.util.Objects;

public class Distance {

    private int distance;

    public Distance(int distance) {
        this.distance = distance;
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

    /**
     * 입력받은 값만큼 거리를 증가합니다.
     * @param distance
     */
    public void addDistance(int distance) {
        this.distance += distance;
    }

    public int getDistance() {
        return this.distance;
    }
}
