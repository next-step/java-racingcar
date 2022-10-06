package nextstep.javaracingcar;

import java.util.Objects;


public class CarDashboard {
    private final String name;
    private final Distance distance;

    public CarDashboard(final String name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Distance distance() {
        return this.distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDashboard that = (CarDashboard) o;

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
        return "CarDashboard{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
