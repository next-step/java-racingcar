package racing.domain;

import java.util.Objects;

public class Car {
    public static final int LOW_POWER = 3;
    public static final int MOVE_POSITION = 1;
    private int position;

    public Car() {
    }

    Car(int position) {
        this.position = position;
    }

    public void move(int power) {
        this.position = power > LOW_POWER ? this.position + MOVE_POSITION : this.position;
    }

    public int getPosition() {
        return this.position;
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
