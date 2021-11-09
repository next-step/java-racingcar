package racingcar;

import java.util.Objects;

public class Car {
    private Info info;
    private Movable movable;

    public Car(Info info, Movable movable) {
        if (!info.valid()) {
            throw new IllegalArgumentException();
        }

        this.info = info;
        this.movable = movable;
    }

    public Info info() {
        return info;
    }

    public void move(int fuel) {
        if (movable.valid(fuel)) {
            this.info = this.info.moved();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(info, car.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }

    @Override
    public String toString() {
        return "Car{" +
                "info=" + info +
                '}';
    }
}
