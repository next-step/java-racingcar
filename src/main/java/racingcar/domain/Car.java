package racingcar.domain;

import racingcar.util.ValidationUtil;

import java.util.Objects;

public class Car implements Cloneable, Comparable<Car> {
    private int position = 0;
    private String name;

    public Car(String name) {
        ValidationUtil.isNameLength(name);
        this.name = name;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public Car clone() {
        Car clone = null;
        try {
            clone = (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.getPosition() == car.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(getPosition(), car.getPosition());
    }
}
