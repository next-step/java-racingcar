package racingcar.strategy;

import racingcar.utils.RandomNumberGenerator;

public class RandomNumberStrategy implements MoveStrategy {

    public static final int RANDOM_MIN_VALUE = 0;
    public static final int RANDOM_MAX_VALUE = 9;
    public static final int MOVE_CODITION_NUMBER = 4;

    @Override
    public boolean canMove() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
        return randomNumber >= MOVE_CODITION_NUMBER;
    }
}
