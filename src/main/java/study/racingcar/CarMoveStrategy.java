package study.racingcar;

import java.util.Random;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MOVE_CONDITION = 4;
    private final Random random = new Random();
    private static final int BOUND_NUMBER = 10;

    @Override
    public boolean isMove() {
        return random.nextInt(BOUND_NUMBER) >= MOVE_CONDITION;
    }
}
