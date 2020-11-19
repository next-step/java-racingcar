package domain;

import java.util.Objects;

public class CarDistance {
    private int distance;

    public CarDistance() {
        this(0);
    }

    public CarDistance(int distance) {
        this.distance = distance;
    }


    public void increase() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDistance distance1 = (CarDistance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
