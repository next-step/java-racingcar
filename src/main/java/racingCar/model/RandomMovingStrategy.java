package racingCar.model;

import racingCar.utils.RandomUtil;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int CAN_MOVE_NUMBER = 4;

    @Override
    public boolean movable() {
        return RandomUtil.getNumber() >= CAN_MOVE_NUMBER;
    }

}
