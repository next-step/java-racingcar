package racingcar;

import java.util.Objects;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;
    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public void tryMove(int number) {
        if (number < MOVE_THRESHOLD) {
            return;
        }
        position += MOVE_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
