package racingcar.MovingStrategy;

import racingcar.domain.MovingStrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MOVE_CRITERIA = 4;
    private static final int MAX_VALUE = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean move() {
        if (RANDOM.nextInt(MAX_VALUE) >= MOVE_CRITERIA) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
