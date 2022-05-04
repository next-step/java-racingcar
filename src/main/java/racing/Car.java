package racing;

import java.util.Objects;

public class Car {
    private static final int START_MOVE_VALUE = 0;

    private Name name;
    private Position position;

    Car(final String name) {
        this(name, new Position(START_MOVE_VALUE));
    }

    Car(String name, int position) {
        this(name, new Position(position));
    }

    Car(String name, Position position) {
        this.name = new Name(name.trim());
        this.position = position;
    }

    Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    void move(int randomNo) {
        position.move(randomNo);
    }

    boolean isWinner(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    int maxPosition(int maxPosition) {
        return position.maxPosition(maxPosition);
    }

    String getName() {
        return name.getName();
    }

    int getPosition() {
        return position.getPosition();
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
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", position=" + position + '}';
    }
}
