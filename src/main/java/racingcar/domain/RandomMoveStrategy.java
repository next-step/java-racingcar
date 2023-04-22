package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 10;
    private static final int MOVED_NUMBER = 4;

    @Override
    public boolean isMove() {
        return random.nextInt(MAX_NUMBER) >= MOVED_NUMBER;
    }
}
