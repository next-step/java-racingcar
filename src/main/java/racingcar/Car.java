package racingcar;

import java.util.Objects;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    void forward() {
        distance++;
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

    public void progress(int number) {
        if (number >= 4) {
            forward();
        }
    }
}
