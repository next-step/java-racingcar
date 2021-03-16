package racingcar.domain.strategy;

import racingcar.utils.RandomNumberGenerator;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private static final int CONDITION_FOR_MOVEMENT = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generate() <= CONDITION_FOR_MOVEMENT;
    }
}
