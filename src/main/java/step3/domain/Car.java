package step3.domain;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return car.name.equals(name) && car.position == position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
