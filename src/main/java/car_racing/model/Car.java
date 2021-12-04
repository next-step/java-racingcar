package car_racing.model;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(START_POSITION, name);
    }

    public Car(int position, String name) {
        this.position = new Position(position);
        this.name = new Name(name);
    }

    public void move(boolean ableToMove) {
        if (ableToMove) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public int getIntPosition() {
        return position.getPosition();
    }

    public Name getName() {
        return name;
    }

    public String getStringName() {
        return name.getString();
    }

    public Position findMaxPosition(Position other) {
        return position.getMaxPosition(other);
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
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
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
