package racingcar.business;

import java.util.Objects;

public class Car {

    private String name;
    private int totalDistance = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        this.totalDistance++;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;

        return Objects.equals(name, car.name) &&
                totalDistance == car.totalDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalDistance);
    }

}
