package domain.racingcar.dto;

import util.RandomNumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_MINIMUM_VALUE_CAN_BE_MOVED = 4;

    @Override
    public boolean checkIfMoveOrNot() {
        return RandomNumberGenerator.range(0, 9) >= RANDOM_MINIMUM_VALUE_CAN_BE_MOVED;
    }
}
