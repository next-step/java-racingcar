package nextstep.javaracingcar;

import java.util.Objects;


public class CarDrivingResult {
    private final CarName name;
    private final Distance distance;

    public CarDrivingResult(final CarName name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public CarDrivingResult(final String name, final Distance distance) {
        this.name = new CarName(name);
        this.distance = distance;
    }

    public Distance distance() {
        return this.distance;
    }

    public boolean isPosition(final Distance distance) {
        return distance.equals(this.distance);
    }

    public Distance maxDistance(final Distance distance) {
        if (this.distance.compareTo(distance) > 0) {
            return this.distance;
        }
        return distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDrivingResult that = (CarDrivingResult) o;

        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarDrivingResult{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
