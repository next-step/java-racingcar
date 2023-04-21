package study.racingcar.strategy;

import java.util.Random;

public class CarMoveStrategy implements MoveStrategy {

    private static final int MOVE_CONDITION = 4;
    private static final int BOUND_NUMBER = 10;
    private final Random random;

    public CarMoveStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMove() {
        return random.nextInt(BOUND_NUMBER) >= MOVE_CONDITION;
    }
}
