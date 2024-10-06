package racingcar.model;

import java.util.Objects;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;
    private int position;


    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateCarName(name);

        this.name = name;
        this.position = position;
    }

    private static void validateCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("차 이름은 필수 입니다.");
        }

        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름은 " + CAR_NAME_MAX_LENGTH + "글자를 초과할 수 없습니다.");
        }
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
