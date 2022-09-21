package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generateLessThan(10) >= 4;
    }
}
