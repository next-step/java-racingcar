package step3.model;

import java.util.Objects;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;

    private final CarName carName;
    private Movement movement;

    public Car(final String carName) {
        this.carName = new CarName(carName);
        this.movement = new Movement();
    }

    public int getMovement() {
        return movement.getMoveCount();
    }

    public String getName() {
        return carName.getCarName();
    }

    public void moveOrStop(final int value) {
        if (value >= MOVE_MIN_NUMBER) {
            movement.move();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }
}
