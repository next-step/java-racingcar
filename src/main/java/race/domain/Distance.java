package race.domain;

import java.util.Objects;

public class Distance {
    private int distance;

    public Distance() {
        this(0);
    }

    public Distance(int distance) {
        validateNaturalNumber(distance);
        this.distance = distance;
    }

    private void validateNaturalNumber(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("자동차 이동 거리는 자연수입니다.");
        }
    }

    public int get() {
        return distance;
    }

    public void add(int moveDistance) {
        distance += moveDistance;
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
}
