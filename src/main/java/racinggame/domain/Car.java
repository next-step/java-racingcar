package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final String name;

    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    Car(final String name, int position) {
        this(name, new Position(position));
    }

    Car(final String name, Position position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            this.position.increase();
    }

    public int max(int other) {
        return this.position.max(other);
    }

    public boolean isMatch(int maxPosition) {
        return this.position.isMatch(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
