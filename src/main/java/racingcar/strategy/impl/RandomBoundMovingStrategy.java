package racingcar.strategy.impl;

import racingcar.model.Car;
import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

public class RandomBoundMovingStrategy implements MovingStrategy {
    private static int MOVABLE_BOUND = 4;
    private static int MOVE_ONE_DISTANCE = 1;


    @Override
    public int move() {
        return MOVE_ONE_DISTANCE;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = RandomNumberUtils.executeRandomNumber();
        return randomNumber >= MOVABLE_BOUND;
    }
}
