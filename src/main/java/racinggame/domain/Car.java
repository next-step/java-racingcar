package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public Car movedCar(RandomValue randomValue) {
        if (randomValue.isMovable())
            return new Car(this.name, position + 1);
        return this;
    }

    public int maxPosition(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
