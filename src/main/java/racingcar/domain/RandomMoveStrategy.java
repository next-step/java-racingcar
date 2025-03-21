package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(10) >= 4;
    }
}