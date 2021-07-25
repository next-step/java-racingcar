package racingcar.strategy;

import racingcar.model.Car;

public interface MovingStrategy {
    int move();

    boolean isMovable();
}
