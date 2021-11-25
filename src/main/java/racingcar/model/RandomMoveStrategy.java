package racingcar.model;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int STANDARD_TO_GO = 4;
    private static final int BOUND_RANDOM_NUMBER = 10;
    private static final Random RANDOM = new Random();

    public RandomMoveStrategy() {
        
    }

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(BOUND_RANDOM_NUMBER) >= STANDARD_TO_GO;
    }
}
