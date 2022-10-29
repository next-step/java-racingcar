package racingcar;

import java.util.Objects;

public class Car {

    final static int MOVE_NUMBER = 4;

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public Car move(int num) {
        if (num >= MOVE_NUMBER) {
            return new Car(++this.position);
        }
        return this;
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
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "-".repeat(Math.max(0, this.position));
    }
}
