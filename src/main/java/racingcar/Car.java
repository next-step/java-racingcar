package racingcar;

import java.util.Objects;

public class Car {
    public static final int VALUE = 3;
    private int distance;
    private String name;

    public Car() {}

    public Car(String name, int distance) {
        name = name.trim();
        if (name.length() > 5) {
            throw new StringIndexOutOfBoundsException();
        }
        this.name = name;
        this.distance = distance;
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(int distance) {
        this("", distance);
    }

    protected void move(int randomNumber) {
        if (randomNumber > VALUE) {
            this.distance++;
        }
    }

    int distance() {
        return this.distance;
    }

    String name() {
        return this.name;
    }

    boolean matchDistance(int distance) {
        return this.distance == distance;
    }

    int max(int maxDistance) {
        if (this.distance > maxDistance) {
            return this.distance;
        }

        return maxDistance;
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
        return Objects.hash(distance, name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name='" + name + '\'' +
                '}';
    }
}
