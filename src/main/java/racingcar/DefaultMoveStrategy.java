package racingcar;

import java.util.Random;

public class DefaultMoveStrategy implements MoveStrategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_OR_STOP_BOUNDARY = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean move() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER) >= MOVE_OR_STOP_BOUNDARY;
    }
}
