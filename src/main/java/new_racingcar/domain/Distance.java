package new_racingcar.domain;

import java.util.Objects;

public class Distance {
    private final int distance;

    public Distance() {
        this.distance = 0;
    }

    private Distance(int distance) {
        this.distance = distance;
    }

    public Distance addDistance() {
        return new Distance(distance + 1);
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return getDistance() == distance1.getDistance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistance());
    }
}
