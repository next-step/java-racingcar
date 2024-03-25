package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;

    private final String name;

    private CarNumber position;

    public Car(final String name) {
        this(name, 0);
    }

    Car(final String name, int position) {
        this(name, new CarNumber(position));
    }

    Car(final String name, CarNumber position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public CarNumber getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(int randomNo) {
        if (randomNo >= FORWARD_NUM)
            this.position.increase();
    }

    public void move(CarRandomNo randomNo) {
        if (randomNo.movable())
            this.position.increase();
    }

    public CarNumber max(CarNumber other) {
        return this.position.max(other);
    }

    public boolean isMatch(CarNumber maxPosition) {
        return this.position.equals(maxPosition);
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
