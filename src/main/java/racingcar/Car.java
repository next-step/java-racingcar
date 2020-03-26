package racingcar;

import java.util.Objects;

public class Car {
    private final int position;
    private static final int ZERO = 0;

    public Car() {
        this.position = ZERO;
    }

    public Car(final int position) {
        this.position = position;
    }

    public Car changeCarPosition(Car car, int randomNumber) {
        MovingStrategy movingStrategy = new MovingStrategy();
        if (movingStrategy.movable(randomNumber)) {
            return new Car(car.position + 1);
        }
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
