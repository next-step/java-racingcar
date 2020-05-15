package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;

public class Car {
    private int location;

    public int move(MovementStrategy movementStrategy) {
        if (movementStrategy.isMovable()) {
            location++;
        }

        return location;
    }
}
