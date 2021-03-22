package racingcar.domain;

import java.util.Objects;

public class Car {
    private final static int START_LOCATION = 0;
    private final static int MOVE_STRATEGY = 1;

    private int currentLocation;
    private Name name;

    public Car() {
        this.currentLocation = START_LOCATION;
    }

    public Car(int location, Name name) {
        this.currentLocation = location;
        this.name = new Name(name);
    }

    public Car(Name name) {
        this.name = new Name(name);
    }

    public Car(Car car) {
        this.currentLocation = car.currentLocation;
        this.name = car.name;
    }

    public void move(Boolean isMove) {
        if (isMove) {
            this.currentLocation = currentLocation + MOVE_STRATEGY;
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public Boolean win(int num) {
        return this.currentLocation > num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return currentLocation == car.currentLocation && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentLocation, name);
    }
}
