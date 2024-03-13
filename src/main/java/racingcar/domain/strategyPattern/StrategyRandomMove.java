package racingcar.domain.strategyPattern;

import racingcar.util.RandomNumberGenerator;

public class StrategyRandomMove implements MoveStrategy{
    private static final int MOVABLE_STANDARD_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generateRandomNumber() >= MOVABLE_STANDARD_NUMBER;
    }
}
