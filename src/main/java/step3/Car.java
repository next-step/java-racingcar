package step3;

import java.util.Objects;

public class Car {

    private int location = 0;

    void moveForward() {
        this.location++;
    }

    public int getLocation() {
        return this.location;
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
        return Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
