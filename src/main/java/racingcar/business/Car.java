package racingcar.business;

import java.util.Objects;

public class Car {

    private String name;
    private int totalDistance;

    private Car(String name) {
        this.name = name;
        this.totalDistance = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return this.name;
    }
    public int getTotalDistance() {
        return this.totalDistance;
    }

    public void race() {
        if (isEnableToMove()) {
            move();
        }
    }

    private void move() {
        this.totalDistance++;
    }

    private boolean isEnableToMove() {
        return (int) (Math.random() * 10) > 3;
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
