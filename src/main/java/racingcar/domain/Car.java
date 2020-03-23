package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int START_POSITION = 0;

    private String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    Car(Car car) {
        this.position = car.getPosition();
        this.name = car.getName();
    }

    Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    Car move(boolean moveCondition) {
        if (moveCondition) {
            position++;
        }
        return new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car car) {
        return getPosition() == car.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition() &&
                Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
