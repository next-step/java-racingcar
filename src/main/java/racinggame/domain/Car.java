package racinggame.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private final Distance distance;
    private final MovingValidator movingValidator;

    public Car(CarName name, Distance distance, MovingValidator movingValidator) {
        this.name = name;
        this.distance = distance;
        this.movingValidator = movingValidator;
    }

    public Car(CarName name, MovingValidator movingValidator) {
        this.name = name;
        this.movingValidator = movingValidator;
        this.distance = new Distance();
    }

    public void move() {
        if (movingValidator.movable()) {
            this.distance.add();
        }
    }

    public Distance movingDistance() {
        return this.distance;
    }

    public boolean sameMoved(Distance distance) {
        return this.distance.equals(distance);
    }

    public CarName name() {
        return this.name;
    }

    public String toStringName() {
        return name.toString();
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
        return Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
