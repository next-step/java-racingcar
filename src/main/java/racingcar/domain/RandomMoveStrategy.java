package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MAX_BOUNDARY = 10;
    private static final int MOVABLE_VALUE = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generateLessThan(MAX_BOUNDARY) >= MOVABLE_VALUE;
    }
}
