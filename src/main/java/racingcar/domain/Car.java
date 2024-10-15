package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;
    private Position position;


    public Car(String name) {
        this(name, new Position());
    }

    public Car(String name, Position position) {
        validateCarName(name);

        this.name = name.trim();
        this.position = position;
    }

    private void validateCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("차 이름은 필수 입니다.");
        }

        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름은 " + CAR_NAME_MAX_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }


    public int currentPosition() {
        return position.currentPosition();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position.increase();
        }
    }

    public int max(int maxPosition) {
        return position.max(maxPosition);
    }


    public boolean isWinner(int maxPosition) {
        return position.hasSamePosition(maxPosition);
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

    public String getName() {
        return name;
    }
}
