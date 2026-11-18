package step3;

import java.util.Objects;

public class Car {

    private final long id;
    private int distance;

    public Car(long id) {
        this.id = id;
        this.distance = 1;
    }

    public void move() {
        ++distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
