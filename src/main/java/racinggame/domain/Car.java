package racinggame.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private final MovingDistance movingDistance;
    private final MovingValidator movingValidator;

    public Car(CarName name, MovingDistance movingDistance, MovingValidator movingValidator) {
        this.name = name;
        this.movingDistance = movingDistance;
        this.movingValidator = movingValidator;
    }

    public Car(CarName name, MovingValidator movingValidator) {
        this.name = name;
        this.movingValidator = movingValidator;
        this.movingDistance = new MovingDistance();
    }

    public void move() {
        if (movingValidator.movable()) {
            this.movingDistance.add();
        }
    }

    public MovingDistance movingDistance() {
        return this.movingDistance;
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
        return Objects.equals(movingDistance, car.movingDistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingDistance);
    }

    public String name() {
        return name.toString();
    }

    public boolean sameMoved(MovingDistance movingDistance) {
        return this.movingDistance.equals(movingDistance);
    }
}
