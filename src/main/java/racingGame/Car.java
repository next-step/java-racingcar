package racingGame;

import java.util.Objects;

public class Car {

    public static final int MOVABLE_LIMIT_NUMBER = 4;

    private final int distance;

    public Car() {
        this(0);
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public Car move(int random) {
        if (random >= MOVABLE_LIMIT_NUMBER) {
            return new Car(distance + 1);
        }
        return this;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return distance == car.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
