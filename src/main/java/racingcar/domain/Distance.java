package racingcar.domain;

import java.util.Objects;

public class Distance {
    private final int distance;

    public Distance() {
        distance = 0;
    }

    public Distance(int distance) {
        if (distance < 0)
            throw new IllegalArgumentException("distance는 음수가 될 수 없습니다.");
        this.distance = distance;
    }

    public Distance increase() {
        return new Distance(distance + 1);
    }

    public Distance decrease() {
        return new Distance(distance - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    public static int compare(Distance distance, Distance distance1) {
        return Integer.compare(distance.distance, distance1.distance);
    }
}
