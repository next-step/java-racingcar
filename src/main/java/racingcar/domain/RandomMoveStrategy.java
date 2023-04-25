package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Integer MINIMUM_NUMBER_TO_MOVE = 4;
    private static final Integer MAX_NUMBER = 10;
    private final Random random;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    public RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean isMovable() {
        return randomNumber() >= MINIMUM_NUMBER_TO_MOVE;
    }

    private Integer randomNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
