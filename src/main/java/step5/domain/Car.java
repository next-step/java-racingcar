package step5.domain;

import java.util.Objects;

public class Car {

    public static final int MAX_NAME = 4;
    public static final int POSSIBLE_MOVE = 3;

    private final Position position;
    private final Name name;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int random) {
        if (random > POSSIBLE_MOVE) {
            position.update();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
