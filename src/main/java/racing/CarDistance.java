package racing;

import java.util.Objects;

public class CarDistance implements Comparable<CarDistance> {
    private static final int DISTANCE_MIN = 0;
    private final int distance;

    public CarDistance() {
        this(DISTANCE_MIN);
    }

    public CarDistance(int distance) {
        if (distance < DISTANCE_MIN) {
            throw new IllegalArgumentException("거리는 0보다 작을 수 없습니다.");
        }
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
