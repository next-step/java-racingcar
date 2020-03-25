package racingcar.domain;

import java.util.Objects;

import static racingcar.domain.RacingGameConstant.START_POSITION;

public class Car {
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
            return new Car(name, position);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car car) {
        return Objects.equals(getPosition(), car.getPosition());
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
