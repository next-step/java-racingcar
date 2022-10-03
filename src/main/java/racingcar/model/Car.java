package racingcar.model;

import racingcar.exception.InvalidParameterException;

import java.util.Objects;

public class Car {
    private static final int RANDOM_BASE_VALUE = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        if (name.length() > 5) {
            throw new InvalidParameterException("자동차 이름이 5자를 초과 할 수 없습니다");
        }

        this.position = position;
        this.name = name;
    }

    public void move(int chosenNumber) {
        if (isMovable(chosenNumber)) {
            this.position += 1;
        }
    }

    private boolean isMovable(int chosenNumber) {
        return chosenNumber >= RANDOM_BASE_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}