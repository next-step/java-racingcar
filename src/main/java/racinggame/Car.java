package racinggame;

import java.util.Objects;

public class Car {

    private final MovingDistance movingDistance;
    private final MovingValidator movingValidator;

    public Car(MovingDistance movingDistance, MovingValidator movingValidator) {
        this.movingDistance = movingDistance;
        this.movingValidator = movingValidator;
    }

    public Car(MovingValidator movingValidator) {
        this.movingValidator = movingValidator;
        this.movingDistance = new MovingDistance();
    }

    public void move() {
        if(movingValidator.movable()) {
            this.movingDistance.add();
        }
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

}
