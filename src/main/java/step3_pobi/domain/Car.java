package step3_pobi.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {

    private final String name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this(name, new Position(position));
    }

    public Car(final String name, final Position position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.position = position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    boolean isMaxPosition(int position) {
        return this.position.isMaxPosition(position);
    }

    int maxPosition(int position) {
        return this.position.maxPosition(position);
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position = position.increase();
        }
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
