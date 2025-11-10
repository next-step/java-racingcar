package study.racing.domain;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_CONDITION = 4;
    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int randonValue) {
        if (randonValue >= MOVE_CONDITION) {
            this.position++;
        }
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
        return Objects.hashCode(position);
    }

    @Override
    public String toString() {
        return "Car{position=" + position + "}";
    }
}
