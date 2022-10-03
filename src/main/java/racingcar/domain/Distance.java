package racingcar.domain;

import java.util.Objects;

public class Distance {
    private final String carName;
    private final int distance;

    public Distance(String carName) {
        this(carName, 0);
    }
    
    public Distance(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public Distance increment() {
        return new Distance(carName,distance + 1);
    }

    public boolean greaterThan(Distance other) {
        return distance > other.distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Distance distance = (Distance) other;
        return this.distance == distance.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
