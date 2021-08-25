package carracing.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private static final int NAME_LIMIT_LENGTH = 5;

    private int location;

    private final Name name;

    public Car(String name) {
        this.location = 0;
        this.name = new Name(name, NAME_LIMIT_LENGTH);
    }

    public int location() {
        return location;
    }

    public Name name() {
        return name;
    }

    public void forward() {
        this.location++;
    }

    public boolean isMovable(int cmd) {
        return cmd >= MOVE_NUMBER;
    }

    public int move(int cmd) {
        if (isMovable(cmd)) {
            forward();
        }
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
