package racingcar.dto;

import java.util.Objects;

public class CarDistance implements Comparable<CarDistance> {
    int distance;

    public CarDistance(int distance) {
        this.distance = distance;
    }

    public void increment() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CarDistance that = (CarDistance) object;

        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public int compareTo(CarDistance carDistance) {
        return Integer.compare(this.distance, carDistance.distance);
    }
}
