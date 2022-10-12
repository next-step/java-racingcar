package racing.core;

import java.util.Objects;

public class Car {

    private static final int STEP_COUNT = 1;
    private int distance = 1;
    private final String carName;

    public Car(String carName) {
        if (carName == null || carName.equals("")) {
            throw new IllegalArgumentException("car name cannot be empty");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("car name length shouldn't be longer than 5");
        }
        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, carName);
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() {
        return this.carName;
    }

    public void stepAhead() {
        this.distance += STEP_COUNT;
    }

    @Override
    public String toString() {
        return carName;
    }
}
