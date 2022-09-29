package nextstep.javaracingcar;

import nextstep.javaracingcar.step2.PositiveNumber;

import java.util.Objects;

public class CarDashboard {
    private final PositiveNumber distance;

    public CarDashboard(PositiveNumber distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDashboard that = (CarDashboard) o;

        return Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        return distance != null ? distance.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CarDashboard{" +
                "distance=" + distance +
                '}';
    }
}
