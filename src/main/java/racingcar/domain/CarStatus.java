package racingcar.domain;

import java.util.Objects;

public final class CarStatus {

    private final CarName name;
    private final Distance distance;

    public CarStatus(final CarName name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public CarName getName() {
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
        final CarStatus carStatus = (CarStatus) o;
        return name.equals(carStatus.name) && distance.equals(carStatus.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
