package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private int position;
    private final Name name;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void moveForward() {
        this.position++;
    }

    public boolean isSamePosition(int comparePosition) {
        return position == comparePosition;
    }

    public int compareMaxPosition(int comparePosition) {
        return Math.max(position, comparePosition);
    }

    public String getCarName() {
        return name.getCarName();
    }

    public int getPosition() {
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
