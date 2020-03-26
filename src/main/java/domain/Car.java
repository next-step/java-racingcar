package domain;

import java.util.Objects;

public class Car {

    private static final int INITIAL_LOCATION = 1;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int location = 0;

    public Car(final String name) {
        this(name, INITIAL_LOCATION);
    }

    public Car(String name, int location) {
        // TODO: validation check
        this.name = name;
        this.location = location;
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
            this.location++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return location == car.location &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

}
