package racing.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int distance;

    Car(String name) {
        this(name, 0);
    }

    Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    Car move(Movable movable) {
        if (movable.isMovable()) {
            return new Car(name, ++distance);
        }
        return new Car(name, distance);
    }

    boolean isLocatedAt(int maxDistance) {
        return this.distance == maxDistance;
    }

    int getGreaterDistance(int distance) {
        return Math.max(this.distance, distance);
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
