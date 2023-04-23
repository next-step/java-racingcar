package racingcar.domain;


import java.util.Objects;

public class Car {
    private int distance;
    private String name;
    private static int START = 0;
    private final int NAME_STANDARD = 5;

    public Car(String name) {
        this(name, START);
    }

    public Car(String name, int distance) {
        this.name = validateName(name);
        this.distance = distance;
    }

    private String validateName(String carName) {
        if (carName.length() > NAME_STANDARD) {
            throw new IllegalArgumentException("over 5 length");
        }
        return carName;
    }

    public int drive()
    {
        return ++distance;
    }

    public int getDistance()
    {
        return distance;
    }

    public String getName() {
        return name;
    }

    public int compare(int distance) {
        if (distance <= this.distance) {
            return this.distance;
        }
        return distance;
    }

    public boolean isSameDistance(int maxDistance) {
        return this.distance == maxDistance;
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
}
