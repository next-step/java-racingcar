package racing;

import java.util.Objects;

public class CarDistance implements Comparable<CarDistance> {
    private final int distance;

    public CarDistance() {
        this(0);
    }

    public CarDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public CarDistance add(int distance) {
        return new CarDistance(this.distance + distance);
    }

    @Override
    public int compareTo(CarDistance other) {
        return Integer.compare(distance, other.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDistance that = (CarDistance) o;
        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
