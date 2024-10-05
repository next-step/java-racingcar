package step3.model;

import java.util.Objects;
import step3.strategy.MoveStrategy;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;

    private final CarName carName;
    private Movement movement;

    public Car(final String carName) {
        this(carName, new Movement());
    }

    public Car(final String carName, final Movement movement) {
        this.carName = new CarName(carName);
        this.movement = movement;
    }

    public int getMovement() {
        return movement.getMoveCount();
    }

    public String getName() {
        return carName.getCarName();
    }

    public void moveOrStop(final int value) {
        if (value >= MOVE_MIN_NUMBER) {
            movement = movement.move();
        }
    }

    public boolean isSameMaxMovement(final int maxMovement) {
        return maxMovement == getMovement();
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
