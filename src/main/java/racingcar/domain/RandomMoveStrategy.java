package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMovable() {
        int number = RandomNumberGenerator.generateLessThan(10);

        return number >= 4;
    }
}
