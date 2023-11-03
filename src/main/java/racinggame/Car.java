package racinggame;

import java.util.Objects;

public class Car {
    private final MovingDistance movingDistance;

    public Car(MovingDistance movingDistance) {
        this.movingDistance = movingDistance;
    }

    public Car() {
        this.movingDistance = new MovingDistance();
    }

    public void move() {
        this.movingDistance.add();
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
        return movingDistance == car.movingDistance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingDistance);
    }

}
