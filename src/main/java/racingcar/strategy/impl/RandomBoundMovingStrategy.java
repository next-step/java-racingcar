package racingcar.strategy.impl;

import racingcar.model.Car;
import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

public class RandomBoundMovingStrategy implements MovingStrategy {
    private static int MOVABLE_BOUND = 4;
    private static int MOVE_ONE_DISTANCE = 1;
    private static int MOVE_ZERO_DISTANCE = 0;

    @Override
    public int move() {
        int randomNumber = RandomNumberUtils.executeRandomNumber();
        if (randomNumber >= MOVABLE_BOUND) {
            return MOVE_ONE_DISTANCE;
        }
        return MOVE_ZERO_DISTANCE;
    }
}
