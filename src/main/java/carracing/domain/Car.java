package carracing.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_NUMBER = 4;

    private final Position position;

    private final Name name;

    public Car(String name) {
        this.position = new Position();
        this.name = new Name(name);
    }

    public Position position() {
        return position;
    }

    public Name name() {
        return name;
    }

    public boolean isMovable(int cmd) {
        return cmd >= MOVE_NUMBER;
    }

    public Position move(int cmd) {
        if (isMovable(cmd)) {
            position.move();
        }
        return position;
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
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

}
