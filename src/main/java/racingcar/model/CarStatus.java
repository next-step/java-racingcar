package racingcar.model;

import java.util.Objects;

public final class CarStatus {

    private final String name;

    private final Distance distance;

    public CarStatus(final String name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarStatus that = (CarStatus) o;
        return name.equals(that.name) && distance.equals(that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
