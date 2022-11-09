package racingcar;

import java.util.Objects;

public class Car {

    final static int MOVE_NUMBER = 4;

    final static int NAME_LENGTH_LIMIT = 5;

    private int position;

    private String name;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public Car(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new RuntimeException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Car move(int num) {
        if (num >= MOVE_NUMBER) {
            return new Car(++this.position);
        }
        return this;
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
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "-".repeat(Math.max(0, this.position));
    }
}
