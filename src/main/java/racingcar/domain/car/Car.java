package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;

public class Car {
    private String name;
    private int location;

    public Car() {
    }

    public Car(String name) {
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
}
