package racingcar.strategy.impl;

import racingcar.model.Car;
import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

public class RandomBoundMovingStrategy implements MovingStrategy {
    private static int MOVABLE_BOUND = 4;

    @Override
    public boolean movable() {
        return RandomNumberUtils.executeRandomNumber() >= MOVABLE_BOUND;
    }
}
