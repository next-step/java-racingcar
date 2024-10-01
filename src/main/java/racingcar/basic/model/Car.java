package racingcar.basic.model;

import java.util.Objects;

public class Car {

    public static final int RANDOM_THRESHOLD = 4;

    private int position;

    public void moveForward(int randomNumber) {
        if (movable(randomNumber)) {
            position++;
        }
    }

    private static boolean movable(int randomNumber) {
        return randomNumber >= RANDOM_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
