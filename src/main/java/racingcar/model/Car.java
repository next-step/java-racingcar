package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private String name;
    private int position;


    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("차 이름은 필수 입니다.");
        }

        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

    public int getMoveCount() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
