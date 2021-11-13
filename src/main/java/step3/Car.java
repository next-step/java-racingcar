package step3;

import java.util.Objects;

public class Car {

    private final static int MOVABLE_COUNT = 4;
    private int location;

    public Car(int location) {
        this.location = location;
    }

    public Car() {
    }

    public int getLocation() {
        return location;
    }

    public Car move(int count) {
        if (count >= MOVABLE_COUNT) {
            location++;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return location == car.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

}
