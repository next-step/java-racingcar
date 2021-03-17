package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int BOUND = 10;
    private static final int CONDITION = 4;
    private final Random random = new Random();

    @Override
    public boolean moveCar() {
        return random.nextInt(BOUND) >= CONDITION;
    }
}
