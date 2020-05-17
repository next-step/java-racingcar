package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;

import java.util.Objects;

public final class Car {
    private final String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public int move(MovementStrategy movementStrategy) {
        if (movementStrategy.isMovable()) {
            location++;
        }

        return location;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 Null 또는 공백이 될 수 없습니다.");
        }
    }
}
