package racingcar.strategy;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int SEPARATE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generate() >= SEPARATE_NUMBER;
    }
}
