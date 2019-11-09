package retry.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int INCREASING_DISTANCE = 1;
    private final String name;
    private final int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(Movable movable) {
        if (movable.isMove()) {
            return new Car(this.name, this.position + INCREASING_DISTANCE);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
