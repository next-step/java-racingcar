package racingCar.model;

import racingCar.utils.NumberUtils;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int COMPARE_VALUE = 4;

    @Override
    public boolean move() {
        return NumberUtils.getRandomNumber() >= COMPARE_VALUE;
    }
}
